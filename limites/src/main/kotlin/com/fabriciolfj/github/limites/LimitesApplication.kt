package com.fabriciolfj.github.limites

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
@ComponentScan("com.fabriciolfj.github.limites")
@EnableMongoRepositories(basePackages = ["com.fabriciolfj.github.limites.domain.repository"])
class LimitesApplication

fun main(args: Array<String>) {
	runApplication<LimitesApplication>(*args)
}
