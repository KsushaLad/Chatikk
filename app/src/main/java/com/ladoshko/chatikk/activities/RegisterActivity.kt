package com.ladoshko.chatikk.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.ladoshko.chatikk.R
import com.ladoshko.chatikk.databinding.ActivityRegisterBinding
import com.ladoshko.chatikk.ui.fragments.EnterPhoneNumberFragment
import com.ladoshko.chatikk.utilits.initFirebase
import com.ladoshko.chatikk.utilits.replaceFragmentRegister

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRegisterBinding
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        mToolbar = mBinding.registerToolbar
        setSupportActionBar(mToolbar)
        title = "Ваш телефон"
       // supportFragmentManager.beginTransaction().add(R.id.register_data_container, EnterPhoneNumberFragment()).commit()
        replaceFragmentRegister(EnterPhoneNumberFragment(), false)
    }

}