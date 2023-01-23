plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {

    compileSdk = ConfigData.compileSdkVersion
    buildToolsVersion = ConfigData.buildToolsVersion

    defaultConfig {
        applicationId = "com.technicaltest.technicalTestApp"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.schemaLocation", "$projectDir/schemas")
                argument("room.incremental", "true")
                argument("room.expandProjection", "true")
            }
        }
    }

    @Suppress("LocalVariableName")
    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")

        }
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
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

    /** ANDROID SDK **/
    implementation(Dependencies.Android.activityCompose)
    implementation(Dependencies.Android.materialCompose)
    implementation(Dependencies.Android.composeUiTooling)
    implementation(Dependencies.Android.constraintLayout)
    /** TIMBER **/
    implementation(Dependencies.timber)

    /** HILT **/
    implementation(Dependencies.Hilt.hiltAndroid)
    implementation(Dependencies.Android.material)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.navigationFragment)
    implementation(Dependencies.Android.navigationUi)
    implementation(Dependencies.Android.navigationDynamicFeatures)
    kapt(Dependencies.Hilt.hiltCompiler)

    // For instrumentation tests
    androidTestImplementation(Dependencies.Hilt.hiltAndroidTesting)
    kaptAndroidTest(Dependencies.Hilt.hiltCompiler)

    // For local unit tests
    testImplementation(Dependencies.Hilt.hiltAndroidTesting)
    kaptTest(Dependencies.Hilt.hiltCompiler)

    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitAndroidExt)

    implementation(project(":feature-songs"))

}

kapt {
    correctErrorTypes = true
}