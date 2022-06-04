package com.example.samplehilt.second_example

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.samplehilt.second_example.di.SecondExampleViewModelScopedModule
import com.example.samplehilt.second_example.domain.OtherSecondExampleRepository
import com.example.samplehilt.second_example.domain.SecondExampleRepository
import com.example.samplehilt.second_example.presentation.SecondExample
import com.example.samplehilt.second_example.presentation.SecondExampleViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.LooperMode
import javax.inject.Inject
import javax.inject.Singleton


/**
 * The SecondCapViewModelScopedModule module is uninstalled
 * because it has a complicated scope for testing
 *
 * it replace for a internal module type singleton component
 */
@UninstallModules( SecondExampleViewModelScopedModule::class )
@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
class SecondExampleTest{

    @Module
    @InstallIn(SingletonComponent::class)
    object SecondExampleTestModule {
        @Singleton
        @Provides
        fun provideOtherSecondExampleRepository() = OtherSecondExampleRepository()
    }
    
    @get:Rule(order = 0)
    val ruleHilt = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: SecondExampleViewModel

    @Inject lateinit var repository: SecondExampleRepository
    @Inject lateinit var otherRepository: OtherSecondExampleRepository

    @Before
    fun setup(){
        ruleHilt.inject()

        viewModel = SecondExampleViewModel(repository, otherRepository)

        composeTestRule.setContent {
            SecondExample(viewModel)
        }
    }

    @Test
    fun `should show the correct text of second repository and other second repository`(){

        composeTestRule.onNodeWithText(repository().title).assertIsDisplayed()
        composeTestRule.onNodeWithText(otherRepository().paragraph).assertIsDisplayed()
    }

}