buildscript {

    val compose_version by extra("1.0.0-beta01")

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-alpha14")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
