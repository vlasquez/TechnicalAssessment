plugins {
    id("com.android.library")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.technicalTest.feature"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompilerVersion
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
    }
}

dependencies {
    implementation(Dependencies.kotlinStdLib)
    implementation(Dependencies.coreKtx)

    /**Android SDK **/
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.material)
    implementation(Dependencies.Android.lifecycleViewModel)
    implementation(Dependencies.Android.coroutines)
    implementation(Dependencies.Android.composeUi)
    implementation(Dependencies.Android.activityCompose)
    implementation(Dependencies.Android.materialCompose)
    implementation(Dependencies.Android.viewModelCompose)
    implementation(Dependencies.Android.composeUiTooling)

    implementation(Dependencies.Android.coil)

    implementation(Dependencies.Android.navigationFragment)
    implementation(Dependencies.Android.navigationUi)
    implementation(Dependencies.Android.navigationDynamicFeatures)

    /** RETROFIT **/
    implementation(Dependencies.Api.retrofit)
    implementation(Dependencies.Api.gson)

    /** HILT **/
    implementation(Dependencies.Hilt.hiltAndroid)
    kapt(Dependencies.Hilt.hiltCompiler)

    implementation(project(":utils"))
    implementation(project(":api"))

    testImplementation(Dependencies.Test.jUnit)
    testImplementation(Dependencies.Test.mockk)

    androidTestImplementation(Dependencies.Test.jUnitAndroidExt)
}