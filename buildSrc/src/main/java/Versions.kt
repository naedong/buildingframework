package kr.co.mmaprojectver10

import org.gradle.api.artifacts.dsl.DependencyHandler


object Versions {
    const val jvmTarget = "1.8"
    const val kotlinCompiler = "1.1.1"
    const val core = "1.7.0"
    const val activityCompose = "1.3.1"
    const val material = "1.1.1"
    const val runTime = "2.3.1"
    const val jUnit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espressoCore = "3.5.1"
    const val daggerhilt = "2.44"
}

object Libraries {

    object ui{
        const val uiTooling = "androidx.compose.ui:ui-tooling-preview:${AppConfig.composeUiVersion}"
        const val uiTestJUint = "androidx.compose.ui:ui-test-junit4:${AppConfig.composeUiVersion}"
        const val uiToolingVersion = "androidx.compose.ui:ui-tooling:${AppConfig.composeUiVersion}"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${AppConfig.composeUiVersion}"
        const val composeUi = "androidx.compose.ui:ui:${AppConfig.composeUiVersion}"
    }
    object ktx{
        const val coreKtx = "androidx.core:core-ktx:${Versions.core}"
    }

    object dagger{
        const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerhilt}"
        const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerhilt}"
    }


    object jUnit{
        const val jUnitTest = "junit:junit:${Versions.jUnit}"
        const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    }

    object  compose{
        const val activityComposeLib = "androidx.activity:activity-compose:${Versions.activityCompose}"
        const val materialCompose = "androidx.compose.material:material:${Versions.material}"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.runTime}"
        const val espressoCores = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    }

    val appLibraries = arrayListOf<String>().apply {
        add(dagger.daggerCompiler)
        add(dagger.daggerHilt)
        add(ktx.coreKtx)
        add(compose.activityComposeLib)
        add(compose.materialCompose)
        add(ui.composeUi)
        add(compose.lifecycleRuntime)
        add(ui.uiTooling)
        add(jUnit.extJUnit)
        add(compose.espressoCores)
        add(ui.uiToolingVersion)
        add(ui.uiTestManifest)
        add(ui.uiTestJUint)
    }
}



fun DependencyHandler.implementation(list: List<String>){
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>){
    list.forEach {dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>){
    list.forEach {dependency ->
        add("debugImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>){
    list.forEach {dependency ->
        add("testImplementation", dependency)
    }
}


