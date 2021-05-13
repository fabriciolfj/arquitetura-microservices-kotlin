package com.fabriciolfj.github.limites.infrastructure;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/fabriciolfj/github/limites/infrastructure/ThreadPoolConfiguration;", "", "()V", "CORE_POOL_SIZE", "", "LOGGER", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "MAX_POOL_SIZE", "beanFactory", "Lorg/springframework/beans/factory/BeanFactory;", "getAsyncExecutor", "Ljava/util/concurrent/Executor;", "getAsyncUncaughtExceptionHandler", "Lorg/springframework/aop/interceptor/AsyncUncaughtExceptionHandler;", "limites"})
@org.springframework.context.annotation.Role(value = org.springframework.beans.factory.config.BeanDefinition.ROLE_INFRASTRUCTURE)
@org.springframework.scheduling.annotation.EnableAsync()
@org.springframework.context.annotation.Configuration()
public class ThreadPoolConfiguration {
    private final org.slf4j.Logger LOGGER = null;
    private final int CORE_POOL_SIZE = 0;
    private final int MAX_POOL_SIZE = 0;
    private final org.springframework.beans.factory.BeanFactory beanFactory = null;
    
    @org.jetbrains.annotations.Nullable()
    public java.util.concurrent.Executor getAsyncExecutor() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
    
    public ThreadPoolConfiguration() {
        super();
    }
}