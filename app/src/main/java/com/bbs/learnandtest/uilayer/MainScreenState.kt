package com.bbs.learnandtest.uilayer

sealed class MainScreenState {
    data object Loading: MainScreenState() // "data object"(recommended) or just "object"
    data class Success(val data: UserData): MainScreenState()
    data class Failure(val message: String): MainScreenState()
}