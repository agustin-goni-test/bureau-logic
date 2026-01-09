package com.example.demo.model.entity;

public class ReportEntity {
    private String correlationId;
    private String provider;  // e.g., "Equifax" or "Plutto"
    private String rawContent; // Raw report content from the provider

    public ReportEntity() {
    }
    
    public ReportEntity(String correlationId, String provider, String rawContent) {
        this.correlationId = correlationId;
        this.provider = provider;
        this.rawContent = rawContent;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getRawContent() {
        return rawContent;
    }

    public void setRawContent(String rawContent) {
        this.rawContent = rawContent;
    }
    
}
