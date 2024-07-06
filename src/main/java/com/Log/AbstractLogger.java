package com.Log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public abstract class AbstractLogger implements Logging {
    protected Logger logger;

    public AbstractLogger(String loggerName, String logFileName) {
        this.logger = Logger.getLogger(loggerName);
        try {
            FileHandler fileHandler = new FileHandler(logFileName, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize log file handler", e);
        }
    }

    @Override
    public void info(String message) {
        logger.log(Level.INFO, message);
    }

    @Override
    public void warn(String message) {
        logger.log(Level.WARNING, message);
    }

    @Override
    public void error(String message) {
        logger.log(Level.SEVERE, message);
    }
}
