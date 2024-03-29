import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    id("maven-publish")
    id("org.springframework.boot") version "2.6.5"
    id("org.jetbrains.kotlin.kapt") version "1.3.61"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.noarg") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.10"
    id("com.google.cloud.tools.jib") version "3.2.0"
}

group = "com.biuea.sportsplatform"
version = "1.0.0"

val env: String by project

jib {
    from {
        image = "eclipse-temurin:11-jre"
    }
    to {
        image = "biuea/sports-platform-file-server:latest"
    }
    container {
        jvmFlags = listOf(
            "-Xms512m",
            "-Xmx1024m"
        )

        environment = mapOf(
            "SPRING_PROFILES_ACTIVE" to "dev"
        )
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

noArg {
    annotation("javax.persistence.Entity")
}

allOpen {
    annotations(
        "javax.persistence.Entity",
        "javax.persistence.MappedSuperclass",
        "javax.persistence.Embeddable"
    )
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/biuea3866/sports-platform-file-server")
            credentials {
                username = System.getenv("GITHUB_USERNAME")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }

    publications {
        create<MavenPublication>("sdk") {
            groupId = "com.biuea.sportsplatform.file"
            artifactId = "sdk"
            version = "1.0.2"

            from(components["java"])

            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }

                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // MySQL Dependencies
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("mysql:mysql-connector-java")

    implementation(group = "org.apache.pdfbox", name = "pdfbox", version = "2.0.29")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
