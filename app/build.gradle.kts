plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") //kotlin symbol processing. for json file processing when parsing the data from API
    id("kotlin-parcelize") //for implementing the parcelable (send bundle of data)
}

android {
    namespace = "com.nabilla.myquranapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nabilla.myquranapp"
        minSdk = 30
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    //FusedLocation
    implementation("com.google.android.gms:play-services-location:21.0.1")

    //coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    //LiveData
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    //moshi -> json converter
    //serialize --> changing the kotlin object to json object
    //deserialize --> changing the json object to kotlin object
    implementation("com.squareup.moshi:moshi:1.14.0")

    //kotlin codegen = code generator
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    //logging interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}