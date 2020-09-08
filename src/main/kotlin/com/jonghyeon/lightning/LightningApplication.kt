package com.jonghyeon.lightning

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LightningApplication

fun main(args: Array<String>) {
    runApplication<LightningApplication>(*args)
}
