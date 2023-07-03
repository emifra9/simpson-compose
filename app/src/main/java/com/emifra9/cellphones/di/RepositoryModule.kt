package com.emifra9.cellphones.di

import com.emifra9.cellphones.data.repository.CellRepository
import com.emifra9.cellphones.data.repository.ICellRepository
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
    abstract  fun providesCellRepository(repository: CellRepository): ICellRepository

}