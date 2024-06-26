plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.contactnumber"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.contactnumber"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation ("com.github.mukeshsolanki:photofilter:1.0.2")

    implementation ("com.karumi:dexter:6.2.2")
    implementation ("com.amulyakhare:com.amulyakhare.textdrawable:1.0.1")
}