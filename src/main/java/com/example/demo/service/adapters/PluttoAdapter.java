package com.example.demo.service.adapters;

import org.springframework.stereotype.Component;

import com.example.demo.model.dto.ReportDTO;
import com.example.demo.model.requests.ReportRequest;

@Component("pluttoAdapter")
public class PluttoAdapter implements ExternalServiceAdapter {

    @Override
    public ReportDTO getReport(ReportRequest request) {
        // Implementar lógica para llamar al servicio de Plutto y mapear la respuesta a ReportDTO
        String content = "Report from Plutto with parameters: " + request.getParameters();
        ReportDTO report = new ReportDTO(request.getCorrelationId(), content);
        return report;
    }
}
