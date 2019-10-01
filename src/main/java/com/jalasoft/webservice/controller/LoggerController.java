package com.jalasoft.webservice.controller;


import com.jalasoft.webservice.model.LoggerManager;
import com.jalasoft.webservice.model.Response;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1.0/logger")
public class LoggerController {
    @PostMapping
    public String  LoggerInitializer () {
        LoggerManager loggerManager = new LoggerManager();
        loggerManager.CreateLogs();
        return "Done";
    }
}
