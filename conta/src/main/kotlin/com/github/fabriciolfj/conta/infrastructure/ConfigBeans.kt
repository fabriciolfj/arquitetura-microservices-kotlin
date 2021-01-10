package com.github.fabriciolfj.conta.infrastructure

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.transaction.ChainedKafkaTransactionManager
import org.springframework.kafka.transaction.KafkaTransactionManager
import org.springframework.orm.jpa.JpaTransactionManager
import javax.persistence.EntityManagerFactory

@Configuration
class ConfigBeans {

    @Bean
    fun mapper() : ObjectMapper {
        return ObjectMapper()
    }

    @Bean
    fun transactionManager(entityManagerFactory: EntityManagerFactory?): JpaTransactionManager? {
        return JpaTransactionManager(entityManagerFactory!!)
    }

    @Bean
    fun chainedKafkaTransactionManager(
        kafkaTransactionManager: KafkaTransactionManager<*, *>?,
        transactionManager: JpaTransactionManager?
    ): ChainedKafkaTransactionManager<Any?, Any?>? {
        return ChainedKafkaTransactionManager(kafkaTransactionManager, transactionManager)
    }

}