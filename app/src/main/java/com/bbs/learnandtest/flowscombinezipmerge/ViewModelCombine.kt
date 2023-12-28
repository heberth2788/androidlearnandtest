package com.bbs.learnandtest.flowscombinezipmerge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bbs.learnandtest.flowscombinezipmerge.dataclass.Post
import com.bbs.learnandtest.flowscombinezipmerge.dataclass.ProfileState
import com.bbs.learnandtest.flowscombinezipmerge.dataclass.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn

class ViewModelCombine : ViewModel() {

    private val user = MutableStateFlow<User?>(null)
    private val posts = MutableStateFlow<List<Post>>(emptyList()) // MutableStateFlow(emptyList<Post>())

    private val userIsAuthenticated = MutableStateFlow(true)

    /**
     * Backing property for the flow of the UI
     * */
    private val _profileState = MutableStateFlow<ProfileState?>(null)
    val profileState = _profileState.asStateFlow() // val profileState: StateFlow<ProfileState?> = _profileState

    /**
     * Flow.combine: combining the most recently emitted values by each flow.
     * */
    init {
        userIsAuthenticated.combine(user) { userIsAuthenticated, user ->
            if(userIsAuthenticated) user else null
        }.combine(posts) { user, posts ->
            user?.let {
                _profileState.value = _profileState.value?.copy(
                    userDni = user.dni.orEmpty(),
                    posts = posts,
                    description = "",
                )
            }
        }.launchIn(viewModelScope)

        /*user.combine(posts) { user, posts ->
            _profileState.value = _profileState.value?.copy(
                userDni = user?.dni.orEmpty(),
                posts = posts,
                description = ""
            )
        }.launchIn(viewModelScope)*/

        // IMPORTANT: The code below do the same as above
        /*viewModelScope.launch {
            user.combine(posts) { user, posts ->
                _profileState.value = _profileState.value?.copy( // ProfileState()
                    userDni = user?.dni.orEmpty(),
                    posts = posts,
                    description = ""
                )
            }.collect()
        }*/
    }
}