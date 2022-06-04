package com.example.samplehilt.first_example

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.samplehilt.core.ArticleComponent

@Composable
fun FirstExample(
    viewModel: FirstExampleViewModel = hiltViewModel()
) {
    ArticleComponent(state = viewModel.state)
}

@Preview(showBackground = true)
@Composable
private fun FirstCapPreview() {
    FirstExample()
}