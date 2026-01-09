package com.example.demo.repository;

import com.example.demo.model.entity.ReportEntity;
import java.util.Optional;

public interface ReportRepository {
    void save(ReportEntity report);
    Optional<ReportEntity> findByCorrelationId(String correlationId);
}
