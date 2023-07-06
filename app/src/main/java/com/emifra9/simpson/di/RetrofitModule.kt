package com.emifra9.simpson.di


import com.emifra9.simpson.BuildConfig
import com.emifra9.simpson.data.domain.usecase.GetCharactersUseCase
import com.emifra9.simpson.data.network.IService
import com.emifra9.simpson.data.repository.IRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitModule {


    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient
            .Builder()
            .build()
    }

     @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://apisimpsons.fly.dev/api/")
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideSimpsonService(retrofit: Retrofit): IService = retrofit.create(IService::class.java)


    @Provides
    @Singleton
    fun providesGetMobilesUseCase(repository: IRepository): GetCharactersUseCase = GetCharactersUseCase(repository)




}