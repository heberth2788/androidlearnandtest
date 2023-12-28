package com.bbs.learnandtest.flowscombinezipmerge.dataclass

data class Post(
    val id: String,
    val userDni: String? = null,
    val imageUrl: String? = null,
    val content: String? = null
)