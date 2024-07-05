package com.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackLogger implements Logging {
    private Logger logger;

    public LogbackLogger(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    @Override
    public void info(String message, String username) {
        logger.info(message);
    }

    @Override
    public void warn(String message, String username) {
        logger.warn(message);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }
}
