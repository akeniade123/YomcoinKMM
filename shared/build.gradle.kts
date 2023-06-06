import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    //Kotlinx ("Serialization")

  //  kotlin("jvm")  // or kotlin("multiplatform") or any other kotlin plugin
    kotlin("plugin.serialization") version "1.8.20"
    id("com.squareup.sqldelight")
    id("org.jetbrains.compose")




    /*

    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")


     */


    /*
    id 'com.android.application'
    id 'kotlin-android'
    id 'com.squareup.sqldelight'
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'
     */
  //  kotlin("plugin.serialization") version "1.8.20"
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    //dependencies versions
    val coroutinesVersion = "1.6.4"
    val koinVersion = "3.3.2"
    val ktorVersion = "2.2.1"

    val sqlDelightVersion = "1.5.5"
    val dateTimeVersion = "0.4.0"

    val serializationVersion = "1.3.0"


    val material3_version = "1.0.1"




    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")



                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

      //          implementation("androidx.navigation:navigation-compose:2.4.0-alpha10")


              //  implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.20")
             //   implementation ("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.11.1")
                // The serialization engine used to convert objects to and from JSON.
              //  implementation "io.ktor:ktor-client-serialization:$ktor_version"

// Logging
            //    implementation ("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")

             //   api("co.touchlab:kermit:0.1.8")

                implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")


                api("io.insert-koin:koin-core:$koinVersion")



                //    implementation ("io.ktor:ktor-client:1.0.0")
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.0.1")

                implementation ("com.google.code.gson:gson:2.10.1")

                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion")

                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion")


                //    implementation ("io.github.microutils:kotlin-logging-jvm:2.0.11")

            //    implementation ("io.github.microutils:kotlin-logging-jvm:3.0.5")


             //   api("org.lighthousegames:logging:$logging_version")


                /*

                //Dagger - Hilt
                implementation ("com.google.dagger:hilt-android:2.38.1")

                kapt ("com.google.dagger:hilt-android-compiler:2.37")
                implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
                kapt ("androidx.hilt:hilt-compiler:1.0.0")
                implementation ("androidx.hilt:hilt-navigation-compose:1.0.0-beta01")

                 */


                // SQL Delight
              //  implementation ("com.squareup.sqldelight:android-driver:1.5.2"
              //  implementation "com.squareup.sqldelight:coroutines-extensions-jvm:1.5.2"
            }


        }


        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }


        val androidMain by getting {
            dependencies {
                /*
                api("io.insert-koin:koin-android:$koinVersion")
                implementation("io.ktor:ktor-client-android:$ktorVersion")

                 */
               // implementation ("io.ktor:ktor-client-android:1.0.0")
               // implementation ("io.ktor:ktor-client-json-jvm:1.0.0")
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.1")


               // implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.1")


                implementation ("io.ktor:ktor-client-okhttp:$ktorVersion")


                implementation ("androidx.compose.material3:material3:$material3_version")


                implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.3.31")

                //It is actual platform implementations
            //    implementation ("io.ktor:ktor-client-serialization-jvm:1.2.2")
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.1")
                implementation ("com.squareup.sqldelight:runtime-jvm:1.1.3")

                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")


            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting



        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies{
               // implementation("io.ktor:ktor-client-darwin:$ktorVersion")
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }

        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}




android {
    namespace = "com.dlvtech.yomcoin"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }

    sourceSets["main"].apply {
        res.srcDirs("src/androidMain/res", "src/commonMain/resources")
    }
}
dependencies {
    implementation("com.google.firebase:firebase-crashlytics-buildtools:2.9.5")
    implementation("androidx.navigation:navigation-runtime-ktx:2.5.3")
}


sqldelight {
    database("AppDatabase") {
        packageName = "com.dlvtech.yomcoin.shared.cache"
    }
}
