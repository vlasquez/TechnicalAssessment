/**
 * To define plugins
 */
object BuildPlugins {
    val kotlinGradlePlugin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}" }
    val gradlePlugin by lazy { "com.android.tools.build:gradle:${Versions.gradlePluginVersion}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}" }
    val hiltPlugin by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}" }
}

/**
 * To define dependencies
 */
object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKTXVersion}" }
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"

    object Android {
        val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompatVersion}" }
        val material by lazy { "com.google.android.material:material:${Versions.materialVersion}" }
        val lifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelVersion}" }
        val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}" }
        val composeUi by lazy { "androidx.compose.ui:ui:${Versions.composeVersion}" }
        val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityComposeVersion}" }
        val materialCompose by lazy { "androidx.compose.material:material:${Versions.composeVersion}" }
        val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.composeVersion}" }
        val coil by lazy { "io.coil-kt:coil-compose:${Versions.coilVersion}" }
        val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}" }
        val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}" }
        val navigationDynamicFeatures by lazy { "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigationVersion}" }
        val navigationSafeArgs by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}" }
        val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintlayoutVersion}" }
        val viewModelCompose by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.viewModelComposeVersion}" }
    }

    object Hilt {
        val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hiltVersion}" }
        val hiltCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.hiltVersion}" }
        val hiltAndroidTesting by lazy { "com.google.dagger:hilt-android-testing:${Versions.hiltVersion}" }
    }

    object Test {
        val jUnit by lazy { "junit:junit:${Versions.jUnitVersion}" }
        val jUnitAndroidExt by lazy { "junit:junit:${Versions.jUnitVersion}" }
        val mockk by lazy { "io.mockk:mockk:${Versions.mockkVersion}" }
        val robolectric by lazy { "org.robolectric:robolectric:${Versions.robolectric}" }
        val kotlinCoroutinesTest by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutineTestVersion}" }
        val turbine by lazy { "app.cash.turbine:turbine:${Versions.turbineVersion}" }
    }

    object Api {
        val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}" }
        val gson by lazy { "com.google.code.gson:gson:${Versions.gsonVersion}" }
        val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.gsonConverterVersion}" }

        val logginInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.httpLoggingInterceptorVersion}" }
        val okHttpClient by lazy { "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}" }
    }
}