package com.emifra9.cellphones.ui.main

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emifra9.cellphones.ui.main.data.domain.usecase.GetMobileUseCase
import com.emifra9.cellphones.ui.main.data.domain.usecase.GetMobilesUseCase
import com.emifra9.cellphones.ui.main.data.dto.Mobile
import com.emifra9.cellphones.ui.main.utils.Status
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
         Log.e("mainvm" , "getMobile" + id)
        coroutineScope.launch {
            val result = getMobileUseCase(id)
            when (result.status) {
                Status.ERROR -> {

                    Log.e("mainvm" ,"ERROR")
                    hideLoading()
                }
                Status.SUCCESS -> {
                    val mobile = result.data

                    Log.e("mainvm" ,"SUCCESS")
                    Log.e("mainvm" , mobile.toString())
                    mobileLiveData.postValue(mobile!!)
                    hideLoading()
                }
                Status.LOADING -> {

                    Log.e("mainvm" ,"LOADING")
                    showLoading()
                }
            }
        }
    }




}