package com.emifra9.cellphones.ui.main.di

import com.emifra9.cellphones.ui.main.data.domain.usecase.GetMobileUseCase
import com.emifra9.cellphones.ui.main.data.domain.usecase.GetMobilesUseCase
import com.emifra9.cellphones.ui.main.data.repository.CellRepository
import com.emifra9.cellphones.ui.main.data.repository.ICellRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
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