package com.example.samplehilt.second_example.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.samplehilt.second_example.domain.OtherSecondExampleRepository
import com.example.samplehilt.second_example.domain.SecondExampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondExampleViewModel @Inject constructor(
    repository: SecondExampleRepository,
    otherRepository: OtherSecondExampleRepository
) : ViewModel() {
    var state by mutableStateOf(repository())
    var otherState by mutableStateOf(otherRepository())
}