package com.example.demo.service.extraction;

import com.example.demo.model.entity.ReportEntity;
import com.example.demo.repository.ReportRepository;
import com.example.demo.service.extraction.ReportExtractionStrategy;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 * Top-level extractor that knows which provider/path contains each business datum (A..E).
 * It loads the stored report, picks the provider-specific strategy and returns business values.
 */
@Component
public class BusinessReportExtractor {

    // injected map of repositories by bean name
    private final Map<String, ReportRepository> repositories;
    // injected map of strategies by bean name ("plutto", "equifax")
    private final Map<String, ReportExtractionStrategy> strategies;

    // business mapping: datum -> provider -> path
    // for simplicity modeled as constants here; could be externalized to config
    private static final String A_PATH_PLUTTO = "/payload/a";
    private static final String A_PATH_EQUIFAX = "/body/fields/A";

    private static final String B_PATH_PLUTTO = "/payload/b";
    private static final String B_PATH_EQUIFAX = "/body/fields/B";

    public BusinessReportExtractor(Map<String, ReportRepository> repositories,
                                   Map<String, ReportExtractionStrategy> strategies) {
        this.repositories = repositories;
        this.strategies = strategies;
    }

    // helper that searches all registered repositories for a report by correlationId
    private Optional<ReportEntity> findReportInRepos(String correlationId) {
        for (ReportRepository repo : repositories.values()) {
            Optional<ReportEntity> found = repo.findByCorrelationId(correlationId);
            if (found.isPresent()) return found;
        }
        return Optional.empty();
    }

    public Optional<String> extractA(String correlationId) {
        Optional<ReportEntity> ent = findReportInRepos(correlationId);
        if (!ent.isPresent()) return Optional.empty();

        ReportEntity report = ent.get();
        ReportExtractionStrategy strategy = strategies.get(report.getProvider());
        if (strategy == null) return Optional.empty();

        JsonNode node = strategy.parse(report.getRawContent());
        String path = choosePathForA(report.getProvider());
        return strategy.extract(path, node);
    }

    public Optional<String> extractB(String correlationId) {
        Optional<ReportEntity> ent = findReportInRepos(correlationId);
        if (!ent.isPresent()) return Optional.empty();

        ReportEntity report = ent.get();
        ReportExtractionStrategy strategy = strategies.get(report.getProvider());
        if (strategy == null) return Optional.empty();

        JsonNode node = strategy.parse(report.getRawContent());
        String path = choosePathForB(report.getProvider());
        return strategy.extract(path, node);
    }

    // a stage covering A,B,C
    public Stage1 extractStage1(String correlationId) {
        return new Stage1(extractA(correlationId).orElse(null),
                          extractB(correlationId).orElse(null),
                          extractC(correlationId).orElse(null));
    }

    public Optional<String> extractC(String correlationId) {
        // similar pattern...
        return Optional.empty();
    }

    // helper to select correct path for A based on provider
    private String choosePathForA(String provider) {
        switch (provider) {
            case "plutto": return A_PATH_PLUTTO;
            case "equifax": return A_PATH_EQUIFAX;
            default: return "";
        }
    }

    private String choosePathForB(String provider) {
        switch (provider) {
            case "plutto": return B_PATH_PLUTTO;
            case "equifax": return B_PATH_EQUIFAX;
            default: return "";
        }
    }

    public static class Stage1 {
        private final String a;
        private final String b;
        private final String c;
        public Stage1(String a, String b, String c) { this.a = a; this.b = b; this.c = c; }
        public String getA() { return a; }
        public String getB() { return b; }
        public String getC() { return c; }
    }
}