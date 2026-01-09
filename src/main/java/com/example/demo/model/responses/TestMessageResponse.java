package com.example.demo.model.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.logging.log4j.message.Message;

@JsonPropertyOrder({ "status", "message" })
public class TestMessageResponse {

    private String status;
    private String message;

    public TestMessageResponse() {
    }

    public TestMessageResponse(String message) {
        this.status = "OK";
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }   
    
}
