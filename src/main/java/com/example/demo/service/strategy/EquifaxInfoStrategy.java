package com.example.demo.service.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.service.adapters.ExternalServiceAdapter;
import com.example.demo.model.dto.ReportDTO;
import com.example.demo.model.requests.ReportRequest;



@Service("equifaxInfoStrategy")
public class EquifaxInfoStrategy implements ObtainInfoStrategy {

    // Esta clase usa un adaptador de tipo genérico, pero que en tiempo de ejecución será
    // una implementación concreta para Equifax
    private final ExternalServiceAdapter adapter;

    public EquifaxInfoStrategy(@Qualifier("equifaxAdapter") ExternalServiceAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public ReportDTO obtainReport(ReportRequest request) {
        // Obtiene reporte para de Equifax usando el adaptador inyectado.
        // Este reporte no requiere considerar un flujo asíncrono, pero
        // si es necesario que esté correctamente loggeado.
        return adapter.getReport(request);
    }
}