package com.example.samplehilt.second_example.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.samplehilt.core.ArticleComponent

@Composable
fun SecondExample(
    viewModel: SecondExampleViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        ArticleComponent(viewModel.state)
        ArticleComponent(state = viewModel.otherState)
    }
}



@Preview(showBackground = true)
@Composable
private fun SecondExamplePreview() {
    SecondExample()
}