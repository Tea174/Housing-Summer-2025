plugins {
    java
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "belgium.antwerp"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation("org.projectlombok:lombok")
    annotationProcessor ("org.projectlombok:lombok")
    implementation ("org.springframework.boot:spring-boot-starter-validation")
//    implementation ("org.springframework.boot:spring-boot-starter-security")
//    implementation ("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-xml")
    implementation ("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor ("org.mapstruct:mapstruct-processor:1.6.3")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation ("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    runtimeOnly ("org.postgresql:postgresql")

}

tasks.withType<Test> {
    useJUnitPlatform()
}

//tasks.named("processResources") {
//    dependsOn("npm_run_build")
//}
