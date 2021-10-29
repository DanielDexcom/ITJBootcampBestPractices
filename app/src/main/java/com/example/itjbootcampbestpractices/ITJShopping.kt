package com.example.itjbootcampbestpractices

import android.app.Application

class ITJShopping: Application() {

    companion object {
        val instance = ITJShopping()
    }

    override fun onCreate() {
        super.onCreate()

    }
}