package com.bbs.learnandtest.flowscombinezipmerge.dataclass

data class ProfileState(
    val userDni: String,
    val posts: List<Post> = emptyList(),
    val description: String? = null,
)
