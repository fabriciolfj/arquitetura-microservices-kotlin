package com.github.fabriciolfj.limite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LimiteApplication

fun main(args: Array<String>) {
	runApplication<LimiteApplication>(*args)
}
