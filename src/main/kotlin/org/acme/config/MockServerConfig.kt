package org.acme.config

import org.mockserver.client.MockServerClient
import org.mockserver.integration.ClientAndServer
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(MockServerConfig.ApplicationProps::class)
class MockServerConfig(private val application: ApplicationProps) {
  @Bean
  fun mockServerClient(): MockServerClient = ClientAndServer.startClientAndServer(application.server.port)

  //===============================================================================================
  //
  //===============================================================================================

  @ConstructorBinding
  @ConfigurationProperties(prefix = "application")
  data class ApplicationProps(val server: ServerProps) {
    data class ServerProps(val port: Int)
  }
}
