package br.com.test.claro.net.embratel.di.module.common

import android.content.Context
import br.com.test.claro.net.embratel.AppDelegate
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: AppDelegate) {

    @Provides
    internal fun provideApp(): AppDelegate {
        return app
    }

    @Provides
    fun provideContext(app: AppDelegate): Context {
        return app.getApplicationContext()
    }

}