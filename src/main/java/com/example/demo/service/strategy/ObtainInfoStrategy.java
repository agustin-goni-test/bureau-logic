package com.example.demo.service.strategy;

import com.example.demo.model.dto.ReportDTO;
import com.example.demo.model.requests.ReportRequest;

public interface ObtainInfoStrategy {
    ReportDTO obtainReport(ReportRequest request);
    
}
