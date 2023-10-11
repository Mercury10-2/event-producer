package com.input.eventproducer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "asyncPoolExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);
        executor.setQueueCapacity(100);
        executor.setMaxPoolSize(200);
        executor.setPrestartAllCoreThreads(true);
        executor.setKeepAliveSeconds(90);
        executor.setThreadGroup(new ThreadGroup("Async"));
        executor.setThreadNamePrefix("async-pool-");
        executor.initialize();
        return executor;
    }
}
