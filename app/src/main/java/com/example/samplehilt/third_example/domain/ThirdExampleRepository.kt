package com.example.samplehilt.third_example.domain

import com.example.samplehilt.core.Article

interface ThirdExampleRepository {

    fun getValue(): Article
}