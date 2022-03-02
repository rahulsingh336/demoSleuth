package com.example.demoSleuth.external;

import com.example.demoSleuth.decorator.MdcTaskDecorator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.CompletableFuture.allOf;
import static java.util.concurrent.CompletableFuture.runAsync;

@Slf4j
@Component
@AllArgsConstructor
public class ExternalService {

    private ThirdParty thirdParty;

    public void sendNotification() throws URISyntaxException {
        //ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setTaskDecorator(new MdcTaskDecorator());
        taskExecutor.setCorePoolSize(30);
        taskExecutor.setMaxPoolSize(40);
        taskExecutor.setQueueCapacity(10);
        taskExecutor.initialize();
        allOf(runAsync(() -> {
            log.info("Hello");
            log.info("MDC context map: {}", MDC.getCopyOfContextMap());
            }, taskExecutor
         )
        ).join();
        thirdParty.call();

    }
}
