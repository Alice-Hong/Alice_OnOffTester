package com.wonderland.alice.onofftester

import android.widget.Button
import androidx.databinding.BindingAdapter

@BindingAdapter("bindingTestStatus")
fun bindTestStatus(button: Button, testing:Boolean = false) {
    if(testing) {
        button.text = "테스트 중지"
    } else {
        button.text = "테스트 시작"
    }
}