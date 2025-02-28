package com.si.fanalytics.match_predictor

import android.app.Application
import com.google.android.gms.ads.MobileAds

//@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) {

        }
    }
}