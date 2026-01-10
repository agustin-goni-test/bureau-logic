package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.logging.AppLogger;
import com.example.demo.model.requests.TestMessageRequest;
import com.example.demo.model.responses.TestMessageResponse;

@RestController
public class InfoController {

    private final AppLogger appLogger;

    public InfoController(AppLogger appLogger) {
        this.appLogger = appLogger;
    }

    @PostMapping("/obtain-info")
    public TestMessageResponse obtainInfo(@RequestBody TestMessageRequest request) {
        String input = request == null || request.getInput() == null ? "No input" : request.getInput();
        appLogger.info("POST /obtain-info called with input: " + input);

        // TODO: delegate to ObtainInfoService or BusinessReportExtractor when available
        return new TestMessageResponse("Obtain-info received: " + input);
    }
}