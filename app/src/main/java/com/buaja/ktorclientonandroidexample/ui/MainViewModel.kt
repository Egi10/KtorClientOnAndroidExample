package com.buaja.ktorclientonandroidexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buaja.ktorclientonandroidexample.domain.usecase.GetCatUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

/**
 * Created by Julsapargi Nursam on 5/24/22.
 * Mobile Engineer - Android
 */

@KoinViewModel
class MainViewModel(
    private val getCatUseCase: GetCatUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    fun getCat() {
        viewModelScope.launch {
            getCatUseCase.invoke()
                .onStart {
                    _uiState.update {
                        it.copy(
                            loading = true
                        )
                    }
                }
                .onCompletion {
                    _uiState.update {
                        it.copy(
                            loading = false
                        )
                    }
                }
                .collect { cat ->
                    _uiState.update {
                        it.copy(
                            url = cat.url
                        )
                    }
                }
        }
    }
}