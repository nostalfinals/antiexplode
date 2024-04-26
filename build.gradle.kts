plugins {
    id("java")
}

group = "ink.nostal.antiexplode"
version = "1.0.0"

repositories {
    mavenCentral()
    maven(uri("https://repo.papermc.io/repository/maven-public/"))
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
}