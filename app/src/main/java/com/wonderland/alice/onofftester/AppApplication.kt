package com.wonderland.alice.onofftester

import android.app.Application

class AppApplication : Application() {

    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    companion object {
        lateinit var INSTANCE: AppApplication
    }

    private fun initialize() {
        UserPreferencesRepository.init(this)
    }
}