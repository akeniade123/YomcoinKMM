plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.4.2").apply(false)
    id("com.android.library").version("7.4.2").apply(false)
    kotlin("android").version("1.8.10").apply(false)
    kotlin("multiplatform").version("1.8.10").apply(false)

    id("org.jetbrains.compose").apply(false)




    /*
    kotlin("multiplatform").apply(false)
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.compose").apply(false)

     */


}


/*
apply plugin: "dev.icerock.mobile.multiplatform-resources"

dependencies {
    commonMainApi("dev.icerock.moko:resources:0.23.0")
    commonMainApi("dev.icerock.moko:resources-compose:0.23.0") // for compose multiplatform

    commonTestImplementation("dev.icerock.moko:resources-test:0.23.0")
}

multiplatformResources {
    multiplatformResourcesPackage = "org.example.library" // required
    multiplatformResourcesClassName = "SharedRes" // optional, default MR
    multiplatformResourcesVisibility = MRVisibility.Internal // optional, default Public
    iosBaseLocalizationRegion = "en" // optional, default "en"
    multiplatformResourcesSourceSet = "commonClientMain"  // optional, default "commonMain"
}
 */


buildscript {
    // ...
    val sqlDelightVersion = "1.5.5"


    repositories {
        gradlePluginPortal()
    }

    dependencies {
        // ...
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")

        classpath("dev.icerock.moko:resources-generator:0.23.0")

    //    classpath ("com.android.tools.build:gradle:7.0.3")
    //    classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")

        /*

         */


    }


    /*
    val sqlDelightVersion = "1.5.3"

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
        classpath("com.android.tools.build:gradle:7.2.2")
    }
     */



}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}





/*
allprojects {
    repositories {
        mavenCentral()
    }
}

 */
