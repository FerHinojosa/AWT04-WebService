/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.webservice.model;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Implements the logger for logging the errors in the webservice.
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class LoggerManager {
    //private static final Logger logger = LogManager.getLogger("HelloWorld");
    private static Logger logger = LogManager.getLogger();
    public void CreateLogs() {
        PropertyConfigurator.configure("C:\\Users\\RaulLaredo\\Documents\\Prog102\\AWT04-WebService\\src\\log4j.properties");
        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.fatal("This is fatal message");
        logger.error("This is error message");
    }
}
