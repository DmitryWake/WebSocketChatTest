package com.example.websocketchattest.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Chat.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Provides
    fun provideChatApi(retrofit: Retrofit): ChatApi = retrofit.create(ChatApi::class.java)

}