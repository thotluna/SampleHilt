package com.example.samplehilt.first_example

import com.example.samplehilt.core.Article
import javax.inject.Inject

class FirstExampleRepository @Inject constructor() {

    operator fun invoke() = Article(
        title = "First Example: Field Injection",
        paragraph = "In this chapter, we tested field Injection and constructor injection."
    )
}