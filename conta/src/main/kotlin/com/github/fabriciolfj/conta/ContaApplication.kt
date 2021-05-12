package com.github.fabriciolfj.conta

import com.github.fabriciolfj.conta.domain.entity.Conta
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableKafka
@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration
@EntityScan(basePackageClasses = [Conta::class])
@ComponentScan("com.github.fabriciolfj.conta")
class ContaApplication

fun main(args: Array<String>) {
	runApplication<ContaApplication>(*args)
}
