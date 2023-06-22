package com.fio.frock.game.app

import android.util.Log
import androidx.core.content.PackageManagerCompat.LOG_TAG
import com.appsflyer.AppsFlyerConversionListener

object Test : AppsFlyerConversionListener {
    override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
        Log.d("sssss","asasasasas")
    }
    override fun onConversionDataFail(error: String?) {
        Log.e(LOG_TAG, "error onAttributionFailure :  $error")
    }
    override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
        // Must be overriden to satisfy the AppsFlyerConversionListener interface.
        // Business logic goes here when UDL is not implemented.
        data?.map {
            Log.d(LOG_TAG, "onAppOpen_attribute: ${it.key} = ${it.value}")
        }
    }
    override fun onAttributionFailure(error: String?) {
        // Must be overriden to satisfy the AppsFlyerConversionListener interface.
        // Business logic goes here when UDL is not implemented.
        Log.e(LOG_TAG, "error onAttributionFailure :  $error")
    }
}