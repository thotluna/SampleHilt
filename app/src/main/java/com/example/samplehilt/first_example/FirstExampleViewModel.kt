package com.example.samplehilt.first_example

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.samplehilt.core.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstExampleViewModel @Inject constructor(
    repository: FirstExampleRepository
) : ViewModel() {
    var state by mutableStateOf<Article>(repository())
}

