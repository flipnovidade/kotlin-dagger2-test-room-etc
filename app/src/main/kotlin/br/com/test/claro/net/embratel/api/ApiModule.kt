package br.com.test.claro.net.embratel.api

import br.com.test.claro.net.embratel.uitls.AppConstant
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.internal.bind.DateTypeAdapter
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlin.jvm.java

@Module
class ApiModule {

    private val timeout = 120

    @Provides
    @Singleton
    fun providesGson(): Gson {

        return GsonBuilder()
                .registerTypeAdapter(Date::class.java, DateTypeAdapter())
                .create()
    }

    @Provides
    @Singleton
    fun providesRestAdapter(gson: Gson): Retrofit {

//        val SIZE_OF_CACHE = (10 * 1024 * 1024).toLong() // 10 MiB
//        val c = Cache(File(AppDelegate.getInstance().getApplicationContext().getCacheDir(), "http"), SIZE_OF_CACHE)

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
                //.cache(c)
                .connectTimeout(timeout.toLong(), TimeUnit.SECONDS)
                .readTimeout(timeout.toLong(), TimeUnit.SECONDS)
                .addInterceptor(logging)
                .writeTimeout(timeout.toLong(), TimeUnit.SECONDS)
                //                .addNetworkInterceptor(new CachingControlInterceptor())
                .build()

        return Retrofit.Builder()
                .baseUrl(AppConstant.Dribbble.URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
    }

    @Provides
    @Singleton
    fun provideService(adapter: Retrofit): ServicesApi {
        return adapter.create(ServicesApi::class.java!!)
    }

    fun service(): ServicesApi {
        val module = ApiModule()
        val gson = module.providesGson()
        val adapter = module.providesRestAdapter(gson)
        return module.provideService(adapter)
    }
}