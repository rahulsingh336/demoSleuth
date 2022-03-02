package com.example.demoSleuth.controller;

import com.example.demoSleuth.external.ExternalService;
import com.example.demoSleuth.notification.Notify;
import com.example.demoSleuth.report.Reporter;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@Slf4j
@RestController
@AllArgsConstructor
public class AppController {

    private Reporter reporter;

    private ExternalService externalService;

    private Notify notify;

    @GetMapping
    public String ping() throws URISyntaxException {
        ThreadContext.put("myKey", "myValue");
        log.info("ENTER :: PING");
        log.info("MDC context map: {}", MDC.getCopyOfContextMap());
        //reporter.report();
        //externalService.sendNotification();
    /*    Try.of(() -> {
            reporter.report();
            return "";
        }).*/
        //notify.sendNotification();
        return "PONG";
    }

    @GetMapping("/self")
    public String self() {
        log.info("ENTER :: SELF");
        return "SELF-CALLED";
    }
}
