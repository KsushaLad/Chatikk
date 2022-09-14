package com.ladoshko.chatikk.ui.fragments

import com.google.firebase.auth.PhoneAuthProvider
import com.ladoshko.chatikk.MainActivity
import com.ladoshko.chatikk.R
import com.ladoshko.chatikk.activities.RegisterActivity
import com.ladoshko.chatikk.utilits.*
import kotlinx.android.synthetic.main.fragment_enter_code.*

class EnterCodeFragment(val mPhoneNumber: String, val id: String) : BaseFragment(R.layout.fragment_enter_code) {

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity). title = mPhoneNumber
        register_input_code.addTextChangedListener (AppTextWatcher{
                val code = register_input_code.text.toString()
                if (code.length >= 5){
                    enterCode()
                }
        })
    }

    private fun enterCode() {
        val code = register_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH_FIREBASE.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                val uId = AUTH_FIREBASE.currentUser?.uid.toString()
                val dateMap = mutableMapOf<String, Any>()
                dateMap[CHILD_ID] = uId
                dateMap[CHILD_PHONE] = mPhoneNumber
                dateMap[CHILD_USERNAME] = uId
                REF_DATABASE_ROOT.child(NODE_USERS).child(uId).updateChildren(dateMap).addOnCompleteListener { task->
                    if (task.isSuccessful){
                        showToast("Добро пожаловать!")
                        (activity as RegisterActivity).replaceActivity(MainActivity())
                    }
                }
            }
        }
    }

}