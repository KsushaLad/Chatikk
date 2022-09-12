package com.ladoshko.chatikk.utilits

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ladoshko.chatikk.R

fun Fragment.showToast(message: String){
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.replaceActivity(activity: AppCompatActivity) {
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}

fun AppCompatActivity.replaceFragmentMain(fragment: Fragment, addStack: Boolean = true) {
    if (addStack){
        supportFragmentManager.beginTransaction()
            .replace(R.id.data_container, fragment)
            .addToBackStack(null)
            .commit()
    } else{
        supportFragmentManager.beginTransaction()
            .replace(R.id.data_container, fragment)
            .commit()
    }
}

fun AppCompatActivity.replaceFragmentRegister(fragment: Fragment, addStack: Boolean = true) {
    if (addStack){
        supportFragmentManager.beginTransaction()
            .replace(R.id.data_container, fragment)
            .addToBackStack(null)
            .commit()
    } else{
        supportFragmentManager.beginTransaction()
            .replace(R.id.data_container, fragment)
            .commit()
    }
}

