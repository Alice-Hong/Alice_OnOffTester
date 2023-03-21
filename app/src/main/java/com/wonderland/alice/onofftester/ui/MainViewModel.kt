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

    /**
     * 기기 재시작 후 처음 화면 꺼짐 이벤트가 발생할 경우 화면켜짐 이벤트로 들어오기 때문에
     * 최소 1번이상 화면꺼짐 이벤트가 발생 후에 화면 켜짐 이벤트 처리를 진행 한다.
     */
    var moreThanOnceScreenOffEvent = false

}