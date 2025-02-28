package com.si.fanalytics.match_predictor

import android.app.Fragment
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.si.f1.f1predictor.core.presentation.ui.PredictorFragment
import com.si.f1.f1predictor.core.sdk.Predictor
import com.si.f1.f1predictor.core.sdk.PredictorGameListener


//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initPredictorGame()
        if(savedInstanceState == null){
            val fragment = PredictorFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.core_container, fragment) // Replace fragment_container with your container ID
                .commit()
        }

    }

    private fun initPredictorGame() {

        Predictor.init(
            context = this,
            token = null,
            userConsent = mapOf(),
            environment = "development",
            locale = "en",
            themeMode = Predictor.THEME_LIGHT
        )

        Predictor.listener = object : PredictorGameListener {
            override fun onLoginRequest() {
            }

            override fun onRegisterRequest() {
            }

            override fun onAnalyticsEvent(eventName: String, params: Bundle?) {
            }

            override fun onAnalyticsScreenLoad(screenName: String, params: Bundle?) {
            }

        }
    }

}

