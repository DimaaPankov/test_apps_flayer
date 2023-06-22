package com.fio.frock.game.black

import android.os.Build
import android.text.TextUtils

class MyPhoneModel {
    companion object {
        fun getYourPhoneModel(): String? {
            val klsdjklsfii = Build.MANUFACTURER
            val shnfkdjhfdkjii = Build.MODEL
            return if (shnfkdjhfdkjii.startsWith(klsdjklsfii)) {
                jksdhkdfjhdfii(shnfkdjhfdkjii)
            } else jksdhkdfjhdfii(klsdjklsfii) + " " + shnfkdjhfdkjii
        }

        private fun jksdhkdfjhdfii(sdkljfdskljdfii: String): String {
            if (TextUtils.isEmpty(sdkljfdskljdfii)) {


            }
            val kdsjhfdfdii = sdkljfdskljdfii.toCharArray()
            var ksdljkdsljdsii = true
            val jsdkhjkdshdfii = StringBuilder()
            for (kdsljksdljdii in kdsjhfdfdii) {
                if (ksdljkdsljdsii && Character.isLetter(kdsljksdljdii)) {

                    jsdkhjkdshdfii.append(kdsljksdljdii)
                    ksdljkdsljdsii = false
                    continue
                } else if (Character.isWhitespace(kdsljksdljdii)) {
                    ksdljkdsljdsii = true
                }
                jsdkhjkdshdfii.append(kdsljksdljdii)
            }

            return jsdkhjkdshdfii.toString()
        }
    }

}