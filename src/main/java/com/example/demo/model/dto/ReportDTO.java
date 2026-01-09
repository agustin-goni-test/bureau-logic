package com.example.demo.model.dto;

public class ReportDTO {

    private String correlationId;
    private String content;

    public ReportDTO() {
    }
    
    public ReportDTO(String correlationId, String content) {
        this.correlationId = correlationId;
        this.content = content;
    }
    
    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}