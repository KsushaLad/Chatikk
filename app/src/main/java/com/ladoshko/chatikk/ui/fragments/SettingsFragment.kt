package com.ladoshko.chatikk.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.ladoshko.chatikk.MainActivity
import com.ladoshko.chatikk.R
import com.ladoshko.chatikk.activities.RegisterActivity
import com.ladoshko.chatikk.utilits.AUTH_FIREBASE
import com.ladoshko.chatikk.utilits.replaceActivity

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
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
        }
        return true
    }

}