package dev.kevalkanpariya.aurajournal

import android.app.Application
import dev.kevalkanpariya.aurajournal.di.initKoin

class FlowDiaryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(this)
    }
}