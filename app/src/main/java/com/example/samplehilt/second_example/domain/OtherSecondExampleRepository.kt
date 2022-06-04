package com.example.samplehilt.second_example.domain

import com.example.samplehilt.core.Article
import javax.inject.Inject

class OtherSecondExampleRepository @Inject constructor() {

    operator fun invoke() = Article(
        title = "ViewModel Scoped",
        paragraph = "This is Other second repository, this has been injected in the same module with" +
                "other module component"
    )
}