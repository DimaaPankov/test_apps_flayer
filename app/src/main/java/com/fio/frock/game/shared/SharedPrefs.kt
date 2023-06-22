package com.apps.tz.rainbowgoldstation.shared

import android.content.Context

class SharedPrefs(private val context: Context) {

    private val pref = context.getSharedPreferences("databaseInfo", Context.MODE_PRIVATE)

    companion object {
        const val STATUS_UNKNOWN = "UNKNOWN"
        const val STATUS_OPEN_GAME = "OPEN_GAME"
        const val STATUS_OPEN_URL = "OPEN_URL"
        const val STATUS_OPEN_SCREEN_THREE = "THREE_SCREEN"

        const val STATUS = "STATUS"
        const val URL = "URL"
        const val CODE = "CODE"
        const val COMPUTER = "COMPUTER"
    }


    fun setStatus(status: String) {
        pref.edit().putString(STATUS, status).apply()
    }

    fun getStatus(): String {
        return pref.getString(STATUS, STATUS_UNKNOWN) ?: STATUS_UNKNOWN
    }

    fun setUrl(url: String) {
        pref.edit().putString(URL, url).apply()
    }

    fun getUrl(): String? {
        return pref.getString(URL, null)
    }

    fun setComputer(url: String) {
        pref.edit().putString(COMPUTER, url).apply()
    }

    fun getComputer(): String? {
        return pref.getString(COMPUTER, "SD89024")?:"SD89024"
    }

    fun setCode(url: String) {
        pref.edit().putString(CODE, url).apply()
    }

    fun getCod(): String {
        return pref.getString(CODE, "HGFG9890")?:"HGFG9890"
    }

}

