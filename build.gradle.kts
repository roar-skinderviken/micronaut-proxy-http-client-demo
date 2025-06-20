plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.micronaut.application)
}

version = "0.1"
group = "no.javatec"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.stdlib.jdk8)

    runtimeOnly("org.yaml:snakeyaml")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-management")
    implementation("io.projectreactor:reactor-core:3.7.7")
    testImplementation("io.micronaut.test:micronaut-test-kotest5")
}

application { mainClass = "no.javatec.ApplicationKt" }
kotlin { jvmToolchain(21) }

micronaut {
    version = libs.versions.micronaut.platform.version
    runtime("netty")
    testRuntime("kotest5")
    processing {
        incremental(true)
        annotations("no.javatec.*")
    }
}



