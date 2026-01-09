package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.responses.*;
import com.example.demo.model.requests.*;


@RestController
public class TestController {

    @GetMapping("/test")
    public TestMessageResponse hello() {
        return new TestMessageResponse("Everything is working fine and we are making changes!");
    }
    
    @PostMapping("/test")
    public TestMessageResponse helloPost(@RequestBody TestMessageRequest request) {

        // Obtener el parámetro del request. Si es vacío usar "No input"
        String input = request.getInput() == null ? "No input" : request.getInput();
        return new TestMessageResponse("You sent: " + input);
    }

}
