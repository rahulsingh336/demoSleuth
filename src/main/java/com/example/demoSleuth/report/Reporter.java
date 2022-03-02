package com.example.demoSleuth.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;

public interface Reporter {

    Logger log = LoggerFactory.getLogger(Reporter.class);

    @Async("processExecutor")
    default void report() {
        log.info("Executing default Method");
        log.info("MDC context map: {}", MDC.getCopyOfContextMap());
    }
}
