plugins {
    id("com.android.application")
    kotlin("android")
    id ("com.google.devtools.ksp") version "1.8.10-1.0.9"
}

android {
    namespace = "com.dlvtech.yomcoin.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.dlvtech.yomcoin.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    applicationVariants.all {
        addJavaSourceFoldersToModel(
            File(buildDir, "generated/ksp/$name/kotlin")
        )
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.4.1")
    implementation("androidx.compose.ui:ui-tooling:1.4.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.1")
    implementation("androidx.compose.foundation:foundation:1.4.0")
    implementation("androidx.compose.material:material:1.4.1")
    implementation("androidx.activity:activity-compose:1.7.0")



    implementation("io.github.raamcosta.compose-destinations:core:1.8.38-beta")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.8.38-beta")


    implementation("androidx.core:core-splashscreen:1.0.0")

    implementation("androidx.datastore:datastore-preferences:1.0.0")

    implementation("io.insert-koin:koin-androidx-compose:3.4.1")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.28.0")


  //  implementation ('io.ktor:ktor-client-okhttp:1.0.0')


    /*
    //implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.1")
    implementation ("io.ktor:ktor-client-okhttp:1.0.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.12.0")

    implementation ("com.squareup.sqldelight:android-driver:1.1.3")

    implementation ("com.facebook.stetho:stetho:1.5.0")

     */




}