package org.acme

import org.acme.config.MockServerConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(MockServerConfig::class)
@EntityScan(basePackages = ["org.acme.domain"])
class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
