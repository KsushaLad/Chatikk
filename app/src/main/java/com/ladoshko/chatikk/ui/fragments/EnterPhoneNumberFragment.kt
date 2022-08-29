package com.ladoshko.chatikk.ui.fragments

import android.widget.Toast
import com.ladoshko.chatikk.R
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*

class EnterPhoneNumberFragment : BaseFragment(R.layout.fragment_enter_phone_number) {

    override fun onResume() {
        super.onResume()
        register_btn_next.setOnClickListener {
            sendCode()
        }
    }

    private fun sendCode() {
       if (register_input_phone.text.toString().isEmpty()){
           Toast.makeText(activity, "Введите номер телефона", Toast.LENGTH_SHORT).show()
       }
    }

}