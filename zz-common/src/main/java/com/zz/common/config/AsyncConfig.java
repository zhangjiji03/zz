package com.zz.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
public class AsyncConfig {

    @Bean("asynExecutor")
    Executor executor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数(默认线程数)
        executor.setCorePoolSize(10);
        // 最多线程数
        executor.setMaxPoolSize(20);
        // 缓冲队列大小
        executor.setQueueCapacity(200);
        // 允许线程空闲时间(单位：默认为秒)
        executor.setKeepAliveSeconds(60);
        // 线程池名前缀
        executor.setThreadNamePrefix("Executor-");
        // 配置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 设置是否等待计划的任务在关闭时完成，而不中断正在运行的任务并执行队列中的所有任务
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置该执行程序在关闭时应阻塞的最大秒数，以等待其余任务完成其执行，然后容器的其余部分继续关闭
        executor.setAwaitTerminationSeconds(60);
        return executor;
    }
}