plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
}
android {
    namespace = "com.example.krishiculture"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.krishiculture"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
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

    buildFeatures {
        viewBinding = true
    }

    packagingOptions {
        exclude("META-INF/NOTICE.md")   // ✅ Exclude duplicate file
        exclude("META-INF/LICENSE.md")  // ✅ Optional: Exclude LICENSE if needed
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    //for weather
    implementation(libs.okhttp)
    implementation(libs.json)
    implementation(libs.play.services.location)

    //for firebase
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)

    //for mail
    implementation(libs.android.mail)
    implementation(libs.android.activation)

    //for push notification
    implementation(libs.firebase.messaging)


    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

}