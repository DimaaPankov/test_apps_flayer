package com.fio.frock.game.app

import android.app.Application
import android.util.Log

import com.appsflyer.AppsFlyerLib
import com.appsflyer.attribution.AppsFlyerRequestListener



class myApp : Application() {

    override fun onCreate() {
        super.onCreate()

        //AppsFlyer()

    }


    fun AppsFlyer(actionToOffer : () -> Unit,actionToGame : () -> Unit) {

        appsFlyerID = AppsFlyerLib.getInstance().getAppsFlyerUID(this)!!

        val token = "PicmH3h3wQDHfapGJ69bSb"



        AppsFlyerLib.getInstance().init(token, AppsFlayerListner(actionToOffer,actionToGame), applicationContext)
        AppsFlyerLib.getInstance().start(applicationContext, token, object :
            AppsFlyerRequestListener {
            override fun onSuccess() {
                Log.d("appsFlayer", "Launch sent successfully")
                Log.d("asa", "kjo")
            }

            override fun onError(errorCode: Int, errorDesc: String) {
                Log.d(
                    "appsFlayer", "Launch failed to be sent:\n" +
                            "Error code: " + errorCode + "\n"
                            + "Error description: " + errorDesc
                )
            }
        })
        AppsFlyerLib.getInstance().setDebugLog(true)


    }


}

