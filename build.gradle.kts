plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.21"
    id("com.google.devtools.ksp") version "2.0.21-1.0.26"
    id("io.micronaut.application") version "4.4.3"
}

version = "0.1"
group = "no.javatec"

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("org.yaml:snakeyaml")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("io.micronaut.serde:micronaut-serde-jackson")
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.stdlib.jdk8)
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-management")
    implementation("io.projectreactor:reactor-core:3.7.2")
    testImplementation("io.micronaut.test:micronaut-test-kotest5")
}

application { mainClass = "no.javatec.ApplicationKt" }
kotlin { jvmToolchain(21) }

micronaut {
    version = libs.versions.micronautPlatform
    runtime("netty")
    testRuntime("kotest5")
    processing {
        incremental(true)
        annotations("no.javatec.*")
    }
}



