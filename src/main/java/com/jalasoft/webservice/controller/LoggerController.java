package com.jalasoft.webservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoggerController {
    private static final Logger LOG = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping("/logger")
    @ResponseBody
    String home() {
        LOG.warn("sending hello world response...");
        return "Hello World!";
    }
}