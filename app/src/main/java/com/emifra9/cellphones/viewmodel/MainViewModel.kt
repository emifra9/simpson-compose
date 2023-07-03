package com.emifra9.cellphones.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emifra9.cellphones.data.domain.usecase.GetMobileUseCase
import com.emifra9.cellphones.data.domain.usecase.GetMobilesUseCase
import com.emifra9.cellphones.data.dto.Mobile
import com.emifra9.cellphones.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMobilesUseCase: GetMobilesUseCase,
    private val getMobileUseCase: GetMobileUseCase,
)  : ViewModel() {

    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    private fun showLoading() = isLoading.postValue(true)
    private fun hideLoading() = isLoading.postValue(false)

    var mobilesLiveData: MutableLiveData<List<Mobile>> = MutableLiveData()
    var mobileLiveData: MutableLiveData<Mobile> = MutableLiveData()


    fun getMobiles() {
        coroutineScope.launch {
            val result = getMobilesUseCase()
            when (result.status) {
                Status.ERROR -> {
                    hideLoading()
                }
                Status.SUCCESS -> {
                    val mobiles = result.data
                    mobilesLiveData.postValue(mobiles!!)
                    hideLoading()
                }
                Status.LOADING -> {
                    showLoading()
                }
            }
        }
    }

     fun getMobile(id: Int) {
        coroutineScope.launch {
            val result = getMobileUseCase(id)
            when (result.status) {
                Status.ERROR -> {
                    hideLoading()
                }
                Status.SUCCESS -> {
                    val mobile = result.data
                    mobileLiveData.postValue(mobile!!)
                    hideLoading()
                }
                Status.LOADING -> {
                    showLoading()
                }
            }
        }
    }




}