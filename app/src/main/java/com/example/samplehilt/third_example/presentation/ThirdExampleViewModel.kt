package com.example.samplehilt.third_example.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.samplehilt.third_example.di.LocalDataSource
import com.example.samplehilt.third_example.domain.ThirdExampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThirdExampleViewModel
@Inject constructor(

//    @RemoteDataSource
    @LocalDataSource
    private val repository: ThirdExampleRepository
): ViewModel() {

    var state by mutableStateOf(repository.getValue())

}