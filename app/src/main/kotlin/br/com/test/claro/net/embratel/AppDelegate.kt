package br.com.test.claro.net.embratel

import android.app.Application
import android.support.multidex.MultiDexApplication
import br.com.test.claro.net.embratel.di.module.common.AppComponent
import br.com.test.claro.net.embratel.di.module.common.AppModule
import br.com.test.claro.net.embratel.di.module.common.DaggerAppComponent

class AppDelegate: Application() {


    companion object {
        lateinit var instance: AppDelegate
            private set

        lateinit var component: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        init()

    }

    fun init(){
        component = DaggerAppComponent.builder()
                    .appModule(AppModule(instance))
                    .build()
        component.inject(instance)
    }

}