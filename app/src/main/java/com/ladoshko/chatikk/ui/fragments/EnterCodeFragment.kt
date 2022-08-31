package com.ladoshko.chatikk.ui.fragments

import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.ladoshko.chatikk.R
import com.ladoshko.chatikk.utilits.AppTextWatcher
import com.ladoshko.chatikk.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_code.*

class EnterCodeFragment : BaseFragment(R.layout.fragment_enter_code) {

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
        register_input_code.addTextChangedListener (AppTextWatcher{
                val code = register_input_code.text.toString()
                if (code.length >= 5){
                    verificate()
                }
        })
    }

    private fun verificate() {
        showToast("OK")
    }

}