package br.com.test.claro.net.embratel.di.module.common

import android.content.Context
import br.com.test.claro.net.embratel.AppDelegate
import br.com.test.claro.net.embratel.api.ApiInteractor
import br.com.test.claro.net.embratel.api.ApiModule
import br.com.test.claro.net.embratel.api.InteractorModule
import br.com.test.claro.net.embratel.api.ServicesApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ (AppModule::class),
                        (ApiModule::class),
                        (InteractorModule::class)] )
interface AppComponent {

    fun inject(app: AppDelegate)

    fun context(): Context

    fun apiInteractor(): ApiInteractor
    
}