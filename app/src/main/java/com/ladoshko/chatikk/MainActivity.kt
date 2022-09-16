package com.ladoshko.chatikk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.ladoshko.chatikk.activities.RegisterActivity
import com.ladoshko.chatikk.databinding.ActivityMainBinding
import com.ladoshko.chatikk.models.User
import com.ladoshko.chatikk.ui.fragments.ChatsFragment
import com.ladoshko.chatikk.ui.objects.AppDrawer
import com.ladoshko.chatikk.utilits.*

class MainActivity : AppCompatActivity() {

   private lateinit var mainBinding: ActivityMainBinding
   lateinit var appDrawer: AppDrawer
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
        if (AUTH_FIREBASE.currentUser != null){
            setSupportActionBar(mToolbar)
            appDrawer.create()
            replaceFragmentMain(ChatsFragment(), false)
            //supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.data_container, ChatsFragment()).commit()
        } else {
            replaceActivity(RegisterActivity())
        }
    }

    private fun initFields() {
        mToolbar = mainBinding.mainToolbar
        appDrawer = AppDrawer(this, mToolbar)
        initFirebase()
        initUser()
    }

    private fun initUser() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID).addListenerForSingleValueEvent(AppValueEventListener{
            USER = it.getValue(User::class.java) ?: User()
        })
    }

}