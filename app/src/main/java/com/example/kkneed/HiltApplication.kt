package com.example.kkneed

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import cn.jiguang.verifysdk.api.JVerificationInterface

import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        initJPushSetting()
    }

    /**
     * 初始化极光认证
     */
    private fun initJPushSetting() {
        JVerificationInterface.init(
            this,
            5000
        ) { code, msg ->
            val logMsg = when (code) {
                8000 -> {
                    "===> 极光认证初始化成功～！ $msg"
                }
                else -> {
                    "===> 极光认证初始化失败！   $msg"
                }
            }
            Log.e("HLQ_Struggle", logMsg)
        }
        // 打开调试模式
        JVerificationInterface.setDebugMode(BuildConfig.DEBUG)
        val verifyEnable = JVerificationInterface.checkVerifyEnable(this)
        if (!verifyEnable) {
            Log.d(TAG, "当前网络环境不支持认证")
            return
        }


    }
}