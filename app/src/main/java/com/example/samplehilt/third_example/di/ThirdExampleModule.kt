package com.example.samplehilt.third_example.di

import com.example.samplehilt.third_example.data.ThirdExampleLocalDataSource
import com.example.samplehilt.third_example.data.ThirdExampleRepositoryImp
import com.example.samplehilt.third_example.data.ThirdExampleRemoteDataSource
import com.example.samplehilt.third_example.domain.ThirdExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Qualifier


@Module
@InstallIn(ViewModelComponent::class)
object ThirdExampleModule {

    @LocalDataSource
    @Provides
    @ViewModelScoped
    fun provideThirdExampleRepositoryLocal(datasource: ThirdExampleLocalDataSource): ThirdExampleRepository{
        return ThirdExampleRepositoryImp(datasource)
    }

    @RemoteDataSource
    @Provides
    @ViewModelScoped
    fun provideThirdExampleRepositoryRemote(datasource: ThirdExampleRemoteDataSource): ThirdExampleRepository{
        return ThirdExampleRepositoryImp(datasource)
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalDataSource

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteDataSource