package com.shersar.ramazon2023.di

import com.shersar.ramazon2023.data.remote.ApiService
import com.shersar.ramazon2023.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, factory: GsonConverterFactory): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(factory)
            .build()
    }
    //nothing changed

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}