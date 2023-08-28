package io.github.farshidroohi.shareviewmodelfragments.parent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ParentShareViewModel : ViewModel() {

    private val _mutableStateFlow = MutableStateFlow(ParentUIState())
    val uiStateStatedFlow: StateFlow<ParentUIState> = _mutableStateFlow.asStateFlow()

    fun increaseValue() {
        viewModelScope.launch {
            val newNumber = _mutableStateFlow.value.number + 1
            _mutableStateFlow.emit(_mutableStateFlow.value.copy(number = newNumber))
        }

    }

    fun reduceValue() {
        viewModelScope.launch {
            val newNumber = _mutableStateFlow.value.number - 1
            _mutableStateFlow.emit(_mutableStateFlow.value.copy(number = newNumber))
        }
    }


}