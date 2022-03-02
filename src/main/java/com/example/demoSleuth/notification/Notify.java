package com.example.demoSleuth.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Notify {

    public void sendNotification () {
        log.info("Throwing error, for checking json layout");
        throw new RuntimeException("Runtime Error thrown");
    }
}
