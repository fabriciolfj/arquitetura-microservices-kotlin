package com.fabriciolfj.github.limites.infrastructure

import org.slf4j.LoggerFactory
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Role
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor


@Configuration
@EnableAsync
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
class ThreadPoolConfiguration {

    private val LOGGER = LoggerFactory.getLogger(ThreadPoolConfiguration::class.java)
    private val CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors()
    private val MAX_POOL_SIZE = CORE_POOL_SIZE * 2
    private val beanFactory: BeanFactory? = null

    fun getAsyncExecutor(): Executor? {
        val executor = ThreadPoolTaskExecutor()
        executor.maxPoolSize = MAX_POOL_SIZE
        executor.corePoolSize = CORE_POOL_SIZE
        executor.setThreadNamePrefix("async-task")
        executor.setBeanName(ThreadPoolConfiguration::class.java.simpleName)
        executor.setQueueCapacity(Int.MAX_VALUE)

        executor.initialize()
        LOGGER.info("M=getAsyncExecutor,corePoolSize={}", CORE_POOL_SIZE)
        return LazyTraceExecutor(beanFactory, executor)
    }

    fun getAsyncUncaughtExceptionHandler(): AsyncUncaughtExceptionHandler? {
        return SimpleAsyncUncaughtExceptionHandler()
    }
}