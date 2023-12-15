package com.bbs.learnandtest.uilayer

import android.app.Application
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat.getString
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bbs.learnandtest.R
import com.bbs.learnandtest.datalayer.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(val repository: PhotoRepository): ViewModel() {

    // Backing property
    private val _uiSate: MutableState<MainScreenState> = mutableStateOf(MainScreenState.Loading)
    val uiState: MutableState<MainScreenState> = _uiSate

//    init {
//        Log.d(TAG, "init")
//        viewModelScope.launch(Dispatchers.Default) {
//            _uiSate.value = MainScreenState.Loading
//        }
//    }

    fun getImageUrl() {
        Log.d(TAG, "getImageUrl")
        _uiSate.value = MainScreenState.Success(UserData(photoUrl = "https://corporate.sixt.com/wp-content/uploads/2021/04/sixt.com-10-business-keys-to-success-pro-success.jpeg"))
    }

    companion object {
        private val TAG = MainScreenViewModel::class.java.simpleName
    }
}