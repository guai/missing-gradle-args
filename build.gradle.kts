plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
}


val isSingleTest =
    project.gradle.startParameter.taskRequests.any { it.args.any { arg -> arg == "--tests" || arg.startsWith("--tests=") } }

logger.lifecycle("!!! isSingletest = $isSingleTest")
logger.lifecycle("!!! taskRequests = ${project.gradle.startParameter.taskRequests.map { it.args }}")


tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}