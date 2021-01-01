package com.fabriciolfj.github.limites

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories(basePackages = arrayOf("com.fabriciolfj.github.limites.domain.repository"))
class LimitesApplication

fun main(args: Array<String>) {
	runApplication<LimitesApplication>(*args)
}
