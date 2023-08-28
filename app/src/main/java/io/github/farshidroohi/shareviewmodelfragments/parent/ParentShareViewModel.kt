package io.github.farshidroohi.shareviewmodelfragments.parent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ParentShareViewModel : ViewModel() {

    private val _mutableSharedFlow = MutableStateFlow(ParentUIState())
    val uiStateStatedFlow: StateFlow<ParentUIState> = _mutableSharedFlow.asStateFlow()

    fun increaseValue() {
        viewModelScope.launch {
            val newNumber = _mutableSharedFlow.value.number + 1
            _mutableSharedFlow.emit(_mutableSharedFlow.value.copy(number = newNumber))
        }

    }

    fun reduceValue() {
        viewModelScope.launch {
            val newNumber = _mutableSharedFlow.value.number - 1
            _mutableSharedFlow.emit(_mutableSharedFlow.value.copy(number = newNumber))
        }
    }


}