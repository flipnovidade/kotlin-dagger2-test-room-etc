package br.com.test.claro.net.embratel.di.module.common

import android.content.Context
import br.com.test.claro.net.embratel.AppDelegate
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {

    fun inject(app: AppDelegate)

    fun context(): Context
}