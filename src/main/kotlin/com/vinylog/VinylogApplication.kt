package com.vinylog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VinylogApplication

fun main(args: Array<String>) {
	runApplication<VinylogApplication>(*args)
}
