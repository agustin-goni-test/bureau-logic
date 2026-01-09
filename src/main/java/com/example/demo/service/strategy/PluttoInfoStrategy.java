package com.example.demo.service.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.service.adapters.ExternalServiceAdapter;
import com.example.demo.model.dto.ReportDTO;
import com.example.demo.model.requests.ReportRequest;

// Esta clase implementa la estrategia para obtener información de Plutto
// @Service sólo es sólo una estereotipo para que Spring la detecte como un componente gestionado

@Service("pluttoInfoStrategy")
public class PluttoInfoStrategy implements ObtainInfoStrategy {

    // Esta clase usa un adaptador de tipo genérico, pero que en tiempo de ejecución será
    // una implementación concreta para Plutto
    private final ExternalServiceAdapter adapter;

    public PluttoInfoStrategy(@Qualifier("pluttoAdapter") ExternalServiceAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public ReportDTO obtainReport(ReportRequest request) {
        // Obtiene reporte para de Plutto usando el adaptador inyectado.
        // En este punto, es necesario implementar la doble lógica de obtención
        // (esto es, GET si ya existe, PUT si hay que solicitarlo al servicio externo).
        return adapter.getReport(request);
    }
}
