package com.example.samplehilt.second_example.di

import com.example.samplehilt.second_example.domain.OtherSecondExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object SecondExampleViewModelScopedModule {

    @ViewModelScoped
    @Provides
    fun provideOtherSecondExampleRepository() = OtherSecondExampleRepository()

}