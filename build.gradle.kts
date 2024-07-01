plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.0"
    id("com.google.devtools.ksp") version "2.0.0-1.0.22"
    id("io.micronaut.application") version "4.4.0"
}

version = "0.1"
group = "no.javatec"

val kotlinVersion= project.properties["kotlinVersion"]

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("org.yaml:snakeyaml")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("io.micronaut.serde:micronaut-serde-jackson")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-management")
    implementation("io.projectreactor:reactor-core:3.6.6")
    testImplementation("io.micronaut.test:micronaut-test-kotest5")
}

application { mainClass = "no.javatec.ApplicationKt" }
kotlin { jvmToolchain(21) }

micronaut {
    runtime("netty")
    testRuntime("kotest5")
    processing {
        incremental(true)
        annotations("no.javatec.*")
    }
}



