pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
       // maven ("https://kotlin.bintray.com/kotlinx")
    }
}

rootProject.name = "yomcoin"
include(":androidApp")
include(":shared")