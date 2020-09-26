import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.gradle.application")
  id("org.gradle.eclipse")
  id("org.gradle.idea")
  id("org.jetbrains.kotlin.jvm")
  id("org.jetbrains.kotlin.plugin.jpa")
  id("org.jetbrains.kotlin.plugin.spring")
  id("org.springframework.boot")
}

// apply(from = "other.gradle.kts")
// apply(plugin = "tld.plugin.identifier")

group = "org.acme"
version = "0.3.0-SNAPSHOT"

configurations {
  // all { exclude(module = "junit") }
}

repositories {
  // mavenLocal() // Uncomment when needed
  jcenter()
}

dependencies {
  //-----------------------------------------------------------------------------------------------
  //  Experimental Dependencies
  //-----------------------------------------------------------------------------------------------

  //-----------------------------------------------------------------------------------------------
  //  BOM Support
  //-----------------------------------------------------------------------------------------------

  implementation(enforcedPlatform("org.springframework.boot:spring-boot-dependencies:${project.property("spring-boot.version")}"))

  //-----------------------------------------------------------------------------------------------
  //  Dependencies
  //-----------------------------------------------------------------------------------------------

  implementation("org.jetbrains.kotlin:kotlin-stdlib")
  implementation("org.mock-server:mockserver-netty:5.11.1")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-validation")

  runtimeOnly("com.h2database:h2")

  //-----------------------------------------------------------------------------------------------
  // Test Dependencies
  //-----------------------------------------------------------------------------------------------
}

//=================================================================================================
//  P L U G I N S
//=================================================================================================

application {
  mainClassName = "org.acme.ApplicationKt"
}

//=================================================================================================
//  T A S K S
//=================================================================================================

tasks {
  withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      javaParameters = true
      jvmTarget = "${JavaVersion.VERSION_11}"
    }
  }

  //-----------------------------------------------------------------------------------------------
  //  Custom Tasks
  //-----------------------------------------------------------------------------------------------
}
