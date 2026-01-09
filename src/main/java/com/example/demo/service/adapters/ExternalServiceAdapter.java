package com.example.demo.service.adapters;

import org.springframework.stereotype.Component;

import com.example.demo.model.dto.ReportDTO;
import com.example.demo.model.requests.ReportRequest;

public interface ExternalServiceAdapter {
    /**
     * Llamar a servicio exrterno y devolver un ReportDTO mapeado.
     * Esta interfaz debe heredarse para generar las llamadas HTTP y el mapeo
     */
    ReportDTO getReport(ReportRequest request);
}
