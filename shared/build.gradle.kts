plugins {
    kotlin("multiplatform")
    id("com.android.library")
    //Kotlinx ("Serialization")

  //  kotlin("jvm")  // or kotlin("multiplatform") or any other kotlin plugin
    kotlin("plugin.serialization") version "1.8.20"
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
        }
    }

    //dependencies versions
    val coroutinesVersion = "1.6.4"
    val koinVersion = "3.3.2"
    val ktorVersion = "2.2.1"

    val serializationVersion = "1.3.0"

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
            //    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")



            //    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

              //  implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.20")


             //   implementation ("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.11.1")


                // The serialization engine used to convert objects to and from JSON.
              //  implementation "io.ktor:ktor-client-serialization:$ktor_version"

// Logging
            //    implementation ("io.ktor:ktor-client-logging:$ktorVersion")

                implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")


                api("io.insert-koin:koin-core:$koinVersion")

            //    implementation ("io.ktor:ktor-client:1.0.0")
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.0.1")

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



                implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.3.31")

                //It is actual platform implementations
            //    implementation ("io.ktor:ktor-client-serialization-jvm:1.2.2")
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.1")
                implementation ("com.squareup.sqldelight:runtime-jvm:1.1.3")

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
}