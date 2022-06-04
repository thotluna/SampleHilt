package com.example.samplehilt.first_example

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
class FirstExampleTest{

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    @Inject
    lateinit var repository: FirstExampleRepository

    private lateinit var firstExampleViewModel: FirstExampleViewModel

    @Before
    fun setUp() {
        hiltRule.inject()
        firstExampleViewModel = FirstExampleViewModel(repository)
    }

    @Test
    fun `should return one screen with article of repository injected`(){
        composeTestRule.setContent {
            FirstExample(firstExampleViewModel)
        }

        composeTestRule.onNodeWithText(repository().title)
        composeTestRule.onNodeWithText(repository().paragraph)
    }
}