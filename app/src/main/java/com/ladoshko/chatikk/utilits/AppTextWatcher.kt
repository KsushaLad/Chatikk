package com.ladoshko.chatikk.utilits

import android.text.Editable
import android.text.TextWatcher

class AppTextWatcher(val onSuccess: (Editable?) -> Unit): TextWatcher {


    override fun afterTextChanged(editable: Editable?) {
        onSuccess(editable)

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

}