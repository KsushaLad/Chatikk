package com.ladoshko.chatikk.ui.fragments

import android.widget.Toast
import com.ladoshko.chatikk.R
import com.ladoshko.chatikk.utilits.showToast
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
           showToast("Введите номер телефона")
       } else {
         activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.register_data_container, EnterCodeFragment())?.addToBackStack(null)?.commit()
//           parentFragmentManager.beginTransaction().replace(R.id.data_container, EnterCodeFragment())
//               .addToBackStack(null).commit()
//           childFragmentManager.beginTransaction().replace(R.id.register_data_container, EnterCodeFragment())
//               .addToBackStack(null).commit()
        // fragmentManager?.beginTransaction()?.replace(R.id.data_container, EnterCodeFragment())
       }
    }

}