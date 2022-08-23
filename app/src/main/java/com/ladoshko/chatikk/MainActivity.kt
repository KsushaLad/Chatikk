package com.ladoshko.chatikk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.ladoshko.chatikk.databinding.ActivityMainBinding
import com.ladoshko.chatikk.ui.fragments.ChatsFragment
import com.ladoshko.chatikk.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {

   private lateinit var mainBinding: ActivityMainBinding
   private lateinit var appDrawer: AppDrawer
   private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunctionality()
    }

    private fun initFunctionality() {
        setSupportActionBar(mToolbar)
        appDrawer.create()
        supportFragmentManager.beginTransaction().replace(R.id.data_container, ChatsFragment()).commit()

    }



    private fun initFields() {
        mToolbar = mainBinding.mainToolbar
        appDrawer = AppDrawer(this, mToolbar)
    }

}