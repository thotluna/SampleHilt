package com.example.samplehilt.third_example.presentation

import com.example.samplehilt.third_example.data.ThirdExampleLocalDataSource
import com.example.samplehilt.third_example.data.ThirdExampleRemoteDataSource
import com.example.samplehilt.third_example.data.ThirdExampleRepositoryImp
import com.example.samplehilt.third_example.di.LocalDataSource
import com.example.samplehilt.third_example.di.RemoteDataSource
import com.example.samplehilt.third_example.di.ThirdExampleModule
import com.example.samplehilt.third_example.domain.ThirdExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.LooperMode
import javax.inject.Inject
import javax.inject.Singleton

@UninstallModules( ThirdExampleModule::class )
@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
class ThirdExampleTest{

    @Module
    @InstallIn(SingletonComponent::class)
    object SecondCapTestModule {
        @LocalDataSource
        @Provides
        @Singleton
        fun provideThirdExampleRepositoryLocal(datasource: ThirdExampleLocalDataSource): ThirdExampleRepository {
            return ThirdExampleRepositoryImp(datasource)
        }

        @RemoteDataSource
        @Provides
        @Singleton
        fun provideThirdExampleRepositoryRemote(datasource: ThirdExampleRemoteDataSource): ThirdExampleRepository {
            return ThirdExampleRepositoryImp(datasource)
        }
    }

    @get:Rule(order = 0)
    val ruleHilt = HiltAndroidRule(this)

    @Inject
    @LocalDataSource
    lateinit var localDataSource: ThirdExampleRepository

    @Inject
    @RemoteDataSource
    lateinit var remoteDataSource: ThirdExampleRepository

    private lateinit var viewModel: ThirdExampleViewModel

    @Before
    fun setUp() {
        ruleHilt.inject()

    }

    @Test
    fun `should return text from Local data source`() {
        viewModel = ThirdExampleViewModel(localDataSource)
        assertEquals(localDataSource.getValue().title, viewModel.state.title)
    }

    @Test
    fun `should return text from Remote data source`() {
        viewModel = ThirdExampleViewModel(remoteDataSource)
        assertEquals(remoteDataSource.getValue().title, viewModel.state.title)
    }



}