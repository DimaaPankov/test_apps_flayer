package com.fio.frock.game.app

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import java.net.URLEncoder

var finalUrl = ""
var goToWebView = {}
var goToGame = {}


class AppsFlayerListner(var actionToOffer:()->Unit = {},var actionToGame:()->Unit) : AppsFlyerConversionListener {




    var adset :String? = null
    var af_adset :String? = null
    var adgroup :String? = null
    var campaign_id :String? = null
    var af_status :String? = null
    var agency :String? = null
    var af_sub3:String? = null
    var af_siteid:String? = null
    var adset_id:String? = null
    var is_fb:String? = null
    var is_first_launch:String? = null
    var click_time:String? = null
    var iscache:String? = null
    var ad_id:String? = null
    var af_sub1:String? = null
    var campaign:String? = null
    var is_paid:String? = null
    var af_sub4:String? = null
    var adgroup_id:String? = null
    var is_mobile_data_terms_signed:String? = null
    var af_channel:String? = null
    var af_sub5:String? = null
    var media_source:String? = null
    var install_time:String? = null
    var af_sub2:String? = null
    var af_message:String? = null
    var sub_id_1:String? = null
    var sub_id_2:String? = null
    var url = ""
    var isOpenWebView = false
    var isOrganicFB = true

    override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {

       Log.d("DataTest",data.toString())

        adset = URLEncoder.encode((data?.get("adset")?:"null").toString(), "utf-8")
        af_adset = URLEncoder.encode((data?.get("af_adset")?: adset).toString(), "utf-8")
        adgroup = URLEncoder.encode((data?.get("adgroup")?:"null").toString(), "utf-8")
        campaign_id = URLEncoder.encode((data?.get("campaign_id")?:"null").toString(), "utf-8")
        af_status = URLEncoder.encode((data?.get("af_status")?:"null").toString(), "utf-8")
        agency = URLEncoder.encode((data?.get("agency")?:"null").toString(), "utf-8")
        af_sub3 = URLEncoder.encode((data?.get("af_sub3")?:"null").toString(), "utf-8")
        af_siteid = URLEncoder.encode((data?.get("af_siteid")?:"null").toString(), "utf-8")
        adset_id = URLEncoder.encode((data?.get("adset_id")?:"null").toString(), "utf-8")
        is_fb = URLEncoder.encode((data?.get("is_fb")?:"null").toString(), "utf-8")
        is_first_launch = URLEncoder.encode((data?.get("is_first_launch")?:"null").toString(), "utf-8")
        click_time = URLEncoder.encode((data?.get("click_time")?:"null").toString(), "utf-8")
        iscache = URLEncoder.encode((data?.get("iscache")?:"null").toString(), "utf-8")
        ad_id = URLEncoder.encode((data?.get("ad_id")?:"null").toString(), "utf-8")
        af_sub1 = URLEncoder.encode((data?.get("af_sub1")?:"null").toString(), "utf-8")
        campaign = URLEncoder.encode((data?.get("campaign")?:"null").toString(), "utf-8")
        is_paid = URLEncoder.encode((data?.get("is_paid")?:"null").toString(), "utf-8")
        af_sub4 = URLEncoder.encode((data?.get("af_sub4")?:"null").toString(), "utf-8")
        adgroup_id = URLEncoder.encode((data?.get("adgroup_id")?:"null").toString(), "utf-8")
        is_mobile_data_terms_signed = URLEncoder.encode((data?.get("is_mobile_data_terms_signed")?:"null").toString(), "utf-8")
        af_channel = URLEncoder.encode((data?.get("af_channel")?:"null").toString(), "utf-8")
        af_sub5 = URLEncoder.encode((data?.get("af_sub5")?:"null").toString(), "utf-8")
        media_source = URLEncoder.encode((data?.get("media_source")?:"null").toString(), "utf-8")
        install_time = URLEncoder.encode((data?.get("install_time")?:"null").toString(), "utf-8")
        af_sub2 = URLEncoder.encode((data?.get("af_sub2")).toString(), "utf-8")
        af_message = (data?.get("af_message")).toString()
        install_time = (data?.get("install_time")).toString()

Log.d("AF_adset", adset!! )
Log.d("AF_af_adset", af_adset!! )
Log.d("AF_adgroup", adgroup!! )
Log.d("AF_campaign_id", campaign_id!! )
Log.d("AF_af_status", af_status!! )
Log.d("AF_agency", agency!! )
Log.d("AF_af_sub3", af_sub3!!)
Log.d("AF_af_siteid", af_siteid!! )
Log.d("AF_adset_id", adset_id!! )
Log.d("AF_is_fb", is_fb!!)
Log.d("AF_is_first_launch", is_first_launch!! )
Log.d("AF_click_time", click_time!! )
Log.d("AF_iscache", iscache!! )
Log.d("AF_ad_id", ad_id!! )
Log.d("AF_af_sub1", af_sub1!! )
Log.d("AF_campaign", campaign!! )
Log.d("AF_is_paid", is_paid!! )
Log.d("AF_af_sub4", af_sub4!! )
Log.d("AF_adgroup_id", adgroup_id!! )
Log.d("AF_is_mobile_data_terms_signed", is_mobile_data_terms_signed!! )
Log.d("AF_af_channel", af_channel!! )
Log.d("AF_af_sub5", af_sub5!!)
Log.d("AF_media_source", media_source!! )
Log.d("AF_install_time", install_time!! )
Log.d("AF_af_message", af_message!! )

 actionToOffer()
    }
override fun onConversionDataFail(error: String?) {
    actionToGame()
    Log.e("appsFlayerData", "error onAttributionFailure :  $error")
}
override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
data?.map {
Log.d("appsFlayerData", "onAppOpen_attribute: ${it.key} = ${it.value}")
}

}
override fun onAttributionFailure(error: String?) {
    actionToGame()
Log.e("appsFlayerData", "error onAttributionFailure :  $error")
}

fun setUrlConvertation(urlFB:String):String{
return urlFB+"sub_id_1=$sub_id_1" +
  "&sub_id_2=$sub_id_2"+
  "&sub_id_3=$af_adset"+
  "&sub_id_4=$campaign_id"+
  "&sub_id_7="/*+"$FirebaseMessaging.getInstance().getToken()"*/+
  "&sub_id_10=$appsFlyerID"+
  "&extra_param_2=$af_sub1"+
  "&extra_param_2=$af_sub1"+
  "&extra_param_3=$af_sub2"+
  "&extra_param_4=$af_sub3"+
  "&extra_param_5=$af_sub4"+
  "&extra_param_6=$af_sub5"+
  "&extra_param_7="+
  "af_id=$appsFlyerID"+
  "&agency=$agency"+
  "&campaign=$campaign"+
  "&campaign_id=$campaign_id"+
  "&media_source=$media_source"+
  "&extra_param_8=$campaign"

}

}