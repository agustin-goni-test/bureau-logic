package com.example.demo.repository;

import com.example.demo.model.entity.ReportEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository("equifaxRepository")
public class EquifaxReportRepository implements ReportRepository {

    private final Map<String, ReportEntity> store = new ConcurrentHashMap<>();

    @Override
    public void save(ReportEntity report) {
        if (report != null && report.getCorrelationId() != null) {
            store.put(report.getCorrelationId(), report);
        }
    }

    @Override
    public Optional<ReportEntity> findByCorrelationId(String correlationId) {
        return Optional.ofNullable(store.get(correlationId));
    }
}
