package com.example.demo.model.requests;

public class ReportRequest {

    private String correlationId;
    private String parameters;

    public ReportRequest() {
    }

    public ReportRequest(String correlationId, String parameters) {
        this.correlationId = correlationId;
        this.parameters = parameters;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
    
}
