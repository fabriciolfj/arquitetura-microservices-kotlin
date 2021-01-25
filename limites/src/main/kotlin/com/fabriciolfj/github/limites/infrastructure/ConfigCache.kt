package com.fabriciolfj.github.limites.infrastructure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.cache.Cache
import org.springframework.cache.CacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class ConfigCache {

    companion object {
        const val CACHE_NAME = "limite"
    }

    @Autowired
    lateinit var properties: RedisProperties

    @Bean
    fun redisConnectionFactoryStandalone(): RedisConnectionFactory? {
        val redisConf = RedisStandaloneConfiguration()
        redisConf.hostName = properties.host
        redisConf.port = properties.port
        return LettuceConnectionFactory(redisConf)
    }

    @Bean
    fun cacheManager(redisConnectionFactory: RedisConnectionFactory?): CacheManager? {
        return redisConnectionFactory?.let {
            getCacheConfiguration()?.let { it1 ->
                RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(it)
                    .withCacheConfiguration(
                        CACHE_NAME,
                        it1
                    )
                    .build()
            }
        }
    }

    @Bean
    fun getCacheConfiguration(): RedisCacheConfiguration? {
        return RedisCacheConfiguration.defaultCacheConfig()
            .serializeKeysWith(
                RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer())
            )
            .serializeValuesWith(
                RedisSerializationContext.SerializationPair
                    .fromSerializer(Jackson2JsonRedisSerializer(String::class.java))
            )
    }

    @Bean
    @Qualifier(CACHE_NAME)
    fun getCacheCustomer(cacheManager: CacheManager): Cache? {
        return cacheManager.getCache(CACHE_NAME)
    }
}