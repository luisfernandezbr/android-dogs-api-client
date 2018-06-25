package br.com.luisfernandez.dogclient

import android.app.Application
import br.com.luisfernandez.dogclient.di.ApplicationModule
import br.com.luisfernandez.dogclient.di.DaggerMainComponent
import br.com.luisfernandez.dogclient.di.MainComponent

class AppApplication: Application() {
    companion object {
        lateinit var component: MainComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerMainComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}