package com.example.samplehilt.third_example.data

import com.example.samplehilt.core.Article
import com.example.samplehilt.third_example.domain.ThirdExampleRepository
import javax.inject.Inject

class ThirdExampleRemoteDataSource @Inject constructor(): ThirdExampleRepository {
    override fun getValue(): Article {
        return Article(
            title = "Remote data source",
            paragraph = "This is a remote data source"
        )
    }
}