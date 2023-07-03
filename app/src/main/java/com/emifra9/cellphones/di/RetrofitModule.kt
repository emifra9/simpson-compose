package com.emifra9.cellphones.di


import com.emifra9.cellphones.BuildConfig
import com.emifra9.cellphones.data.domain.usecase.GetMobileUseCase
import com.emifra9.cellphones.data.domain.usecase.GetMobilesUseCase
import com.emifra9.cellphones.data.network.ICellService
import com.emifra9.cellphones.data.repository.ICellRepository
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


    //@Singleton
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

    // @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://61967289af46280017e7e0c0.mockapi.io/")
        .client(okHttpClient)
        .build()

    //@Singleton
    @Provides
    fun provideTorreService(retrofit: Retrofit): ICellService = retrofit.create(ICellService::class.java)


    @Provides
    @Singleton
    fun providesGetMobilesUseCase(repository: ICellRepository): GetMobilesUseCase = GetMobilesUseCase(repository)


    @Provides
    @Singleton
    fun providesGetMobileUseCase(repository: ICellRepository): GetMobileUseCase = GetMobileUseCase(repository)



}