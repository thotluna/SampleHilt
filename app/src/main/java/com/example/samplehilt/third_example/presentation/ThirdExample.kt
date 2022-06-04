package com.example.samplehilt.third_example.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.samplehilt.core.ArticleComponent


@Composable
fun ThirdCap(
    viewModel: ThirdExampleViewModel = hiltViewModel()
) {
    ArticleComponent(viewModel.state)
}


@Preview(showBackground = true)
@Composable
private fun SecondExamplePreview() {
    ThirdCap()
}