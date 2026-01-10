package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.dto.ReportDTO;
import com.example.demo.service.strategy.ObtainInfoStrategy;
import com.example.demo.service.strategy.EquifaxInfoStrategy;
import com.example.demo.service.strategy.PluttoInfoStrategy;
import com.example.demo.model.requests.ReportRequest;

/**
 * Service that holds an array of ObtainInfoStrategy implementations.
 * For now the array is explicitly instantiated with two elements (Plutto and Equifax).
 */
@Service
public class ObtainInfoService {

    private final ObtainInfoStrategy[] strategies;

    public ObtainInfoService() {
        // instantiate the strategies now; later you can wire real strategy beans instead
        this.strategies = new ObtainInfoStrategy[] {
            new PluttoInfoStrategy(),
            new EquifaxInfoStrategy()
        };
    }

    public ObtainInfoStrategy[] getStrategies() {
        return strategies.clone();
    }

    /**
     * Call all strategies and return their ReportDTOs.
     * Implementation is minimal for now; extend with request params / error handling later.
     */
    public ReportDTO[] obtainAllReports() {

        // First create the report request to be passed to each strategy
        // For now it's empty; will add parameters later
        // NOT QUITE SURE YET IF THE STRUCTURE OF ReportRequest IS RIGHT
        ReportRequest reportRequest = new ReportRequest();

        // Then, call each strategy and collect results
        ReportDTO[] results = new ReportDTO[strategies.length];
        for (int i = 0; i < strategies.length; i++) {
            results[i] = strategies[i].obtainReport(reportRequest);
        }
        return results;
    }
}
