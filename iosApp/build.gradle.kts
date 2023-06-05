plugins {
    id("org.jetbrains.gradle.apple.applePlugin") version "212.4638.14-0.13.1"
    id("org.jetbrains.kotlin.native.cocoapods")
    id("org.jetbrains.kotlin.multiplatform")
}
version = "2.0"
kotlin {
    ios()
    cocoapods {
        summary = "Kotlin sample project with CocoaPods dependencies"
        homepage = "https://github.com/Kotlin/kotlin-with-cocoapods-sample"
        ios.deploymentTarget = "14.5"
        pod("AFNetworking") {
            version = "~> 4.0.1"
        }
        pod("Alamofire")
    }
}
apple {
    iosApp {
        productName = "KMMwithCocoaPods"

        sceneDelegateClass = "SceneDelegate"
        launchStoryboard = "LaunchScreen"

        //productInfo["NSAppTransportSecurity"] = mapOf("NSAllowsArbitraryLoads" to true)
        //buildSettings.OTHER_LDFLAGS("")

        dependencies {
            implementation(project(":shared"))
        }
    }
}


/*

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


  //  implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.2")
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.cardview:cardview:1.0.0")



    implementation("io.github.raamcosta.compose-destinations:core:1.8.38-beta")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.8.38-beta")


    implementation("androidx.core:core-splashscreen:1.0.0")

    implementation("androidx.datastore:datastore-preferences:1.0.0")

    implementation("io.insert-koin:koin-androidx-compose:3.4.1")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.28.0")

    implementation ("io.ktor:ktor-client-okhttp:1.0.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")






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

 */