package com.tigerit.rickandmortycharacterviewer.di

import android.app.Application
import com.tigerit.rickandmortycharacterviewer.data.repository.Repository
import com.tigerit.rickandmortycharacterviewer.data.repository.remote.api.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCharacterRepository(apiService: APIService): Repository {
        return Repository(apiService)
    }
}