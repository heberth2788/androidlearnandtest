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
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ViewModelMerge : ViewModel() {

    private val flow1: Flow<Int> = (1..10).asFlow().onEach { delay(1000L) }
    private val flow2: Flow<Int> = (10..20).asFlow().onEach { delay(300L) }

    var intStr by mutableStateOf("")
        private set

    /**
     * merge: Merges the given flows into a single flow without preserving an order
     * of elements. All flows are merged concurrently, without limit on the number of
     * simultaneously collected flows.
     * */
    init {
        merge(flow1, flow2).onEach {
            intStr += "($it)\n"
        }.launchIn(viewModelScope)

        // IMPORTANT: The code below do the same as above
        /*viewModelScope.launch {
            merge(flow1, flow2).onEach {
                intStr += "($it)\n"
            }.collect()
        }*/

        // Assigning the Flow.merge() to a variable, first way:
        /*val togetherAux1: Flow<Int> = merge(flow1, flow2).onEach { intStr += "($it)\n" }
        togetherAux1.launchIn(viewModelScope)*/

        // Assigning the Flow.merge() to a variable, second way:
        /*viewModelScope.launch {
            val togetherAux2: Flow<Int> = merge(flow1, flow2).onEach { intStr += "($it)\n" }
            togetherAux2.collect {
                print(it)
            }
        }*/
    }
}