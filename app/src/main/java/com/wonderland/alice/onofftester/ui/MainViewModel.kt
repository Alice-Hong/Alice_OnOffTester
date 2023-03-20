package com.wonderland.alice.onofftester.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _onTesting = MutableLiveData<Boolean>(false)
    val onTesting: LiveData<Boolean>
        get() = _onTesting

    fun changeOnTesting(b:Boolean) {
        _onTesting.value = b
    }

}