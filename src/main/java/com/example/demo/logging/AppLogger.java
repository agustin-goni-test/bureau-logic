package com.example.demo.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppLogger {

    // root logger (optional)
    private final Logger root = LoggerFactory.getLogger("application");

    // return a typed logger for a class
    public Logger get(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    // static helper to obtain a logger without injecting the bean
    public static Logger staticLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    // instance convenience methods
    public void info(String message) { root.info(message); }
    public void debug(String message) { root.debug(message); }
    public void warn(String message) { root.warn(message); }
    public void error(String message) { root.error(message); }
    public void error(String message, Throwable t) { root.error(message, t); }
    public void trace(String message) { root.trace(message); }
}
