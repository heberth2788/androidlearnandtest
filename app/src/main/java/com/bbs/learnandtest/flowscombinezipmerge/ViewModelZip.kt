package com.bbs.learnandtest.flowscombinezipmerge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

class ViewModelZip : ViewModel() {

    // Just to explain the operator ".." that is a Range type
    val rangeA: IntRange = (1..10)

    private val flow1: Flow<Int> = (1..10).asFlow().onEach { delay(1000L) }
    private val flow2: Flow<Int> = (10..20).asFlow().onEach{ delay(300L) }
    var intStr by mutableStateOf("")
        private set

    /**
     * Flow.zip: The resulting flow completes as soon as one of the flows completes and
     * cancel is called on the remaining flow
     * */
    init {
        flow1.zip(flow2) { int1, int2 ->
            intStr += "($int1, $int2)\n"
        }.launchIn(viewModelScope)

        // IMPORTANT: The code below do the same as above
        /*viewModelScope.launch {
            flow1.zip(flow2) { int1, int2 ->
                intStr += "($int1, $int2)\n"
            }.collect()
        }*/
    }
}
