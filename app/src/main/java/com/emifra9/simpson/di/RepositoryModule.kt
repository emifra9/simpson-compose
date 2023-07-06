package com.emifra9.simpson.di

import com.emifra9.simpson.data.repository.IRepository
import com.emifra9.simpson.data.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract  fun providesRepository(repository: Repository): IRepository

}