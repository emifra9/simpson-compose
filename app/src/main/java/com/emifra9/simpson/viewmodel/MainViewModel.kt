package com.emifra9.simpson.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.emifra9.simpson.data.domain.usecase.GetCharactersUseCase
import com.emifra9.simpson.data.dto.CartoonList
import com.emifra9.simpson.utils.Resource
import com.emifra9.simpson.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMobilesUseCase: GetCharactersUseCase
)  : ViewModel() {

    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    private val _loading = mutableStateOf(false)
    val loading: State<Boolean> get() = _loading

    private val _cartoonListState = mutableStateOf<Resource<CartoonList>>(Resource.success(null))
    val cartoonListState: State<Resource<CartoonList>> = _cartoonListState

    fun getCharacters() {
        coroutineScope.launch {
            _loading.value = true
            val result = getMobilesUseCase()
            when (result.status) {
                Status.SUCCESS -> {
                    _cartoonListState.value = result
                    _loading.value = false
                }
                else-> {
                    _loading.value = true
                }
            }
        }
    }



}