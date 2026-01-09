package com.example.demo.service.extraction;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Optional;

/**
 * Strategy to extract values from an external report structure.
 * Implementations map/report-specific structures (Plutto, Equifax, ...) to a common form.
 */
public interface ReportExtractionStrategy {

    JsonNode parse(String rawReport);

    Optional<String> extract(String path, JsonNode reportNode);
}
