package com.hh.springmavendemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author YAOSHUNYU
 * @Date 2019/10/24
 * @Time 11:19
 */

@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Value("${threadpool.corepoolsize}")
    private Integer corePoolSize;
    @Value("${threadpool.maxpoolsize}")
    private Integer maxPoolSize;
    @Value("${threadpool.queuecapacity}")
    private Integer queueCapacity;
    @Value("${threadpool.keepaliveseconds}")
    private Integer keepAliveSeconds;
    @Value("${threadpool.threadnameprefix}")
    private String threadNamePrefix;

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列容量
        executor.setQueueCapacity(queueCapacity);
        //配置线程活跃时间（秒）
        executor.setKeepAliveSeconds(keepAliveSeconds);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(threadNamePrefix);
        //配置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
