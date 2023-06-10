package com.dlvtech.yomcoin.utils

import ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
//import com.rickclephas.kmm.viewmodel.MutableStateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class TimeTravelViewModel: ViewModel() {

    private val _color  = MutableStateFlow(0xFFFFFFFF)
    var color = _color.asStateFlow()

    var composeColor by mutableStateOf(0xFFFFFFFF)
        private set

    fun generateNewColor(){
        val color = Random.nextLong(0xFFFFFFFF)
        _color.value = color
        composeColor = color
    }

    private val _clr = MutableStateFlow(0x000000)
    var tint = _clr.asStateFlow()
    fun TintColor(clr: Int){
        _clr.value = clr
        println(clr)
    }

    /*
    private val clockTime = Clock.time

    /**
     * A [StateFlow] that emits the actual time.
     */
    val actualTime = clockTime.map { formatTime(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "N/A")

    private val _travelEffect = MutableStateFlow<TravelEffect?>(viewModelScope, null)
    /**
     * A [StateFlow] that emits the applied [TravelEffect].
     */
    val travelEffect = _travelEffect.asStateFlow()

     */

}