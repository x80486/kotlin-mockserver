pluginManagement {
  repositories {
    // mavenLocal() // Uncomment when needed
    gradlePluginPortal()
    mavenCentral()
  }

  plugins {
    val kotlinVersion = settings.extra["kotlin.version"] as String
    val springVersion = settings.extra["spring-boot.version"] as String

    id("org.jetbrains.kotlin.jvm").version(kotlinVersion)
    id("org.jetbrains.kotlin.plugin.jpa").version(kotlinVersion)
    id("org.jetbrains.kotlin.plugin.spring").version(kotlinVersion)
    id("org.springframework.boot").version(springVersion)
  }
}

rootProject.name = "kotlin-mockserver"
