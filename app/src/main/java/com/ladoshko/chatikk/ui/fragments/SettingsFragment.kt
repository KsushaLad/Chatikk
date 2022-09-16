package com.ladoshko.chatikk.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.ladoshko.chatikk.MainActivity
import com.ladoshko.chatikk.R
import com.ladoshko.chatikk.activities.RegisterActivity
import com.ladoshko.chatikk.utilits.AUTH_FIREBASE
import com.ladoshko.chatikk.utilits.USER
import com.ladoshko.chatikk.utilits.replaceActivity
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFields()
    }

    private fun initFields() {
        settings_bio.text = USER.bio
        settings_username.text = USER.username
        settings_phone_number.text = USER.phone
        settings_status.text = USER.status
        settings_name.text = USER.fullname
        settings_btn_change_user_name.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.data_container, ChangeUsernameFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_menu_exit -> {
                AUTH_FIREBASE.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> {
               activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.data_container, ChangeNameFragment())
                    ?.addToBackStack(null)
                    ?.commit()
            }
        }
        return true
    }

}