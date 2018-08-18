package br.com.test.claro.net.embratel.api

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Inject

@Module
class InteractorModule {

    @Provides
    fun provideApiInteractor(): ApiInteractor {
        return ApiInteractorImpl()
    }

}