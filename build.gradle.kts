buildscript {

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-alpha14")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt").version("1.16.0")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

subprojects {
    plugins.apply("io.gitlab.arturbosch.detekt")

    detekt {
        toolVersion = "1.16.0"
        allRules = true
        config = files("$rootDir/config/detekt.yml")
        buildUponDefaultConfig = true
    }
}
