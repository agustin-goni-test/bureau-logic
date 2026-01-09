package com.example.demo.service.extraction;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component("equifax")
public class EquifaxExtractionStrategy implements ReportExtractionStrategy {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public JsonNode parse(String rawReport) {
        try { return mapper.readTree(rawReport); }
        catch (Exception e) { return mapper.createObjectNode(); }
    }

    @Override
    public Optional<String> extract(String path, JsonNode reportNode) {
        // Example: Equifax might use a different convention; still use JSON Pointer here for simplicity
        try {
            JsonNode node = reportNode.at(path);
            return node.isMissingNode() ? Optional.empty() : Optional.ofNullable(node.asText(null));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}