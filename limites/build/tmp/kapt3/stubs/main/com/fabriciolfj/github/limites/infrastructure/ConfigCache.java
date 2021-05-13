package com.fabriciolfj.github.limites.infrastructure;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0017J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\nH\u0017J\n\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0017R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u0097.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/fabriciolfj/github/limites/infrastructure/ConfigCache;", "", "()V", "properties", "Lorg/springframework/boot/autoconfigure/data/redis/RedisProperties;", "getProperties", "()Lorg/springframework/boot/autoconfigure/data/redis/RedisProperties;", "setProperties", "(Lorg/springframework/boot/autoconfigure/data/redis/RedisProperties;)V", "cacheManager", "Lorg/springframework/cache/CacheManager;", "redisConnectionFactory", "Lorg/springframework/data/redis/connection/RedisConnectionFactory;", "getCacheConfiguration", "Lorg/springframework/data/redis/cache/RedisCacheConfiguration;", "getCacheCustomer", "Lorg/springframework/cache/Cache;", "redisConnectionFactoryStandalone", "Companion", "limites"})
@org.springframework.context.annotation.Configuration()
public class ConfigCache {
    @org.springframework.beans.factory.annotation.Autowired()
    public org.springframework.boot.autoconfigure.data.redis.RedisProperties properties;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CACHE_NAME = "limite";
    @org.jetbrains.annotations.NotNull()
    public static final com.fabriciolfj.github.limites.infrastructure.ConfigCache.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public org.springframework.boot.autoconfigure.data.redis.RedisProperties getProperties() {
        return null;
    }
    
    public void setProperties(@org.jetbrains.annotations.NotNull()
    org.springframework.boot.autoconfigure.data.redis.RedisProperties p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.springframework.context.annotation.Bean()
    public org.springframework.data.redis.connection.RedisConnectionFactory redisConnectionFactoryStandalone() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.springframework.context.annotation.Bean()
    public org.springframework.cache.CacheManager cacheManager(@org.jetbrains.annotations.Nullable()
    org.springframework.data.redis.connection.RedisConnectionFactory redisConnectionFactory) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.springframework.context.annotation.Bean()
    public org.springframework.data.redis.cache.RedisCacheConfiguration getCacheConfiguration() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.springframework.beans.factory.annotation.Qualifier(value = "limite")
    @org.springframework.context.annotation.Bean()
    public org.springframework.cache.Cache getCacheCustomer(@org.jetbrains.annotations.NotNull()
    org.springframework.cache.CacheManager cacheManager) {
        return null;
    }
    
    public ConfigCache() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/fabriciolfj/github/limites/infrastructure/ConfigCache$Companion;", "", "()V", "CACHE_NAME", "", "limites"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}