package com.github.fabriciolfj.conta.infrastructure

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConfigBeans {

    @Bean
    fun mapper() : ObjectMapper {
        return ObjectMapper()
    }
}