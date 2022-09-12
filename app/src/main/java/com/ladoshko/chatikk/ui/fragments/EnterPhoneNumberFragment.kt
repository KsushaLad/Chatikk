package com.ladoshko.chatikk.ui.fragments

import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.ladoshko.chatikk.MainActivity
import com.ladoshko.chatikk.R
import com.ladoshko.chatikk.activities.RegisterActivity
import com.ladoshko.chatikk.utilits.AUTH_FIREBASE
import com.ladoshko.chatikk.utilits.replaceActivity
import com.ladoshko.chatikk.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*
import java.util.concurrent.TimeUnit

class EnterPhoneNumberFragment : BaseFragment(R.layout.fragment_enter_phone_number) {

    private lateinit var mPhoneNumber: String
    private lateinit var callBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onStart() {
        super.onStart()
        callBack = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                AUTH_FIREBASE.signInWithCredential(credential).addOnCompleteListener {
                    if (it.isSuccessful){
                        showToast("Добро пожаловать!")
                        (activity as RegisterActivity).replaceActivity(MainActivity())
                    }
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                showToast(p0.message.toString())
            }

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.register_data_container, EnterCodeFragment(mPhoneNumber, id))?.addToBackStack(null)?.commit()
            }
        }
        register_btn_next.setOnClickListener {
            sendCode()
        }
    }

    private fun sendCode() {
       if (register_input_phone.text.toString().isEmpty()){
           showToast("Введите номер телефона")
       } else {
           authUser()
        // activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.register_data_container, EnterCodeFragment())?.addToBackStack(null)?.commit()
        // fragmentManager?.beginTransaction()?.replace(R.id.data_container, EnterCodeFragment())
       }
    }

    private fun authUser() {
        mPhoneNumber = register_input_phone.text.toString()
       // PhoneAuthProvider.getInstance().verifyPhoneNumber(mPhoneNumber, 60, TimeUnit.SECONDS, activity as RegisterActivity, callBack)
        val options = PhoneAuthOptions.newBuilder(AUTH_FIREBASE)
            .setPhoneNumber(mPhoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(activity as RegisterActivity)
            .setCallbacks(callBack)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

}