package com.example.demoSleuth.schedular;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Slf4j
@Component
public class TestSchedular {

    //@Scheduled(initialDelay = 1000, fixedRate = 1000)
    public void run() {
        log.info("Current time is :: " + Calendar.getInstance().getTime());
    }
}
