plugins {
    id("java")
    id("io.qameta.allure") version "2.9.4"
}

group = "org.example"
version = "1.0-SNAPSHOT"

allure {
    report {
        version.set("2.24.0")
    }
    adapter {
        autoconfigure.set(true)
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set("2.24.0")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.codeborne:selenide:6.17.2")
    implementation("io.qameta.allure:allure-java-commons:2.24.0")
    implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.3.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.3.0")
}
