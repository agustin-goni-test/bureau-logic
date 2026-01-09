package com.example.demo.service.extraction;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component("plutto")
public class PluttoExtractionStrategy implements ReportExtractionStrategy {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public JsonNode parse(String rawReport) {
        try { return mapper.readTree(rawReport); }
        catch (Exception e) { return mapper.createObjectNode(); }
    }

    @Override
    public Optional<String> extract(String path, JsonNode reportNode) {
        // Example: interpret path as JSON Pointer for Plutto
        try {
            JsonNode node = reportNode.at(path); // path like "/root/owner/name"
            return node.isMissingNode() ? Optional.empty() : Optional.ofNullable(node.asText(null));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}