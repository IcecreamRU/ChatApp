package ru.icecreamru.chatcompose.di

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Named


@Module
class NetworkModule {

    fun provideOkHttpClient(
        context: Context
    ): OkHttpClient {
        val okBuilder = OkHttpClient.Builder()
        return okBuilder.build()
    }

    @Provides
    fun provideRetrofitBuilder(
        okHttpClient: OkHttpClient,
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpClient)
    }
}