package com.example.samplehilt.second_example.di

import com.example.samplehilt.second_example.domain.SecondExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SecondExampleSingletonModule {

    @Singleton
    @Provides
    fun provideSecondExampleRepository() = SecondExampleRepository()

}