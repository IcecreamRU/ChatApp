package ru.icecreamru.chatcompose.features.auth.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.icecreamru.chatcompose.features.auth.data.AuthApi
import ru.icecreamru.chatcompose.features.auth.data.AuthRepositoryImpl
import ru.icecreamru.chatcompose.features.auth.domain.AuthRepository
import ru.icecreamru.chatcompose.utils.BASE_URL

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {
    @Binds
    abstract fun provide(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Provides
    fun provideApi(
        retrofit: Retrofit.Builder,
        okHttpClient: OkHttpClient
    ): AuthApi {
        return retrofit.baseUrl(BASE_URL)
            .client(okHttpClient.newBuilder().build())
            .build()
            .create(AuthApi::class.java)
    }
}


