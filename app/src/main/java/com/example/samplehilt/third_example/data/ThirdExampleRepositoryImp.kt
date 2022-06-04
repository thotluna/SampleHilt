package com.example.samplehilt.third_example.data

import com.example.samplehilt.core.Article
import com.example.samplehilt.third_example.domain.ThirdExampleRepository
import javax.inject.Inject

class ThirdExampleRepositoryImp
@Inject constructor(
    private val dataSource: ThirdExampleRepository
): ThirdExampleRepository {
    override fun getValue(): Article {
        return dataSource.getValue()
    }
}