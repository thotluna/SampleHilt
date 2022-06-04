package com.example.samplehilt.second_example.domain

import com.example.samplehilt.core.Article
import javax.inject.Inject

class SecondExampleRepository @Inject constructor() {

    operator fun invoke() = Article(
        title = "Singleton Scoped",
        paragraph = "This is the second chapter, we going to learn about scope"
    )
}





