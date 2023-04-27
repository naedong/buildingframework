import kr.co.mmaprojectver10.DefaultConfig
import kr.co.mmaprojectver10.Libraries

plugins {
    // id("org.jetbrains.kotlin.kapt")
    id("com.google.devtools.ksp")

//    id("com.google.dagger.hilt.android")

    id("com.android.application")
    id("org.jetbrains.kotlin.android")

}

android {
    namespace = "kr.co.mmaprojectver10"
    compileSdk = DefaultConfig.compildSdk

            defaultConfig {
                applicationId = "kr.co.mmaprojectver10"
                minSdk = DefaultConfig.minSdk
                        targetSdk = DefaultConfig.targetSdk
                        versionCode = DefaultConfig.versionCode
                        versionName = DefaultConfig.versionName

                        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                vectorDrawables {
                    useSupportLibrary = true
                }
            }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = DefaultConfig.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = DefaultConfig.kotlinExtensionVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }


}

dependencies {

    implementation(Libraries.dagger.daggerHilt)

// kapt 대안으로 룸 작업
    ksp("androidx.room:room-compiler:2.5.0")

    implementation(Libraries.ktx.coreKtx)
    implementation(Libraries.compose.lifecycleRuntime)
    implementation(Libraries.compose.activityComposeLib)
    implementation(Libraries.ui.composeUi)
    implementation(Libraries.ui.uiTooling)
    implementation(Libraries.compose.materialCompose)


    testImplementation(Libraries.jUnit.jUnitTest)


    androidTestImplementation(Libraries.jUnit.extJUnit)
    androidTestImplementation(Libraries.compose.espressoCores)
    androidTestImplementation(Libraries.ui.uiTestJUint)

    debugImplementation(Libraries.ui.uiToolingVersion)
    debugImplementation(Libraries.ui.uiTestManifest)
}
