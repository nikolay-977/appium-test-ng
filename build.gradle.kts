plugins {
    java
}

group = "ru.skillfactory"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.10.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.6.2")
    implementation("io.appium:java-client:8.5.1")
    testImplementation("org.testng:testng:7.8.0")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    useTestNG()
    systemProperty("file.encoding", "UTF-8")
}