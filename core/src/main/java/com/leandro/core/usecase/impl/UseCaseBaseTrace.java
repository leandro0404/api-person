package com.leandro.core.usecase;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class UseCaseBaseTrace {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void logStart() {
        log.info("Start UseCase " + this.getClass().getSimpleName());
    }

    public void logEnd() {
        log.info("End UseCase " + this.getClass().getSimpleName());
    }

    public void logError(Exception ex) {
        log.error("Error UseCase: " + this.getClass().getSimpleName() + " message: " + ex.getMessage());
    }

    public void logNotFound() {
        log.info("not found data in usecase: " + this.getClass().getSimpleName());
    }
}
