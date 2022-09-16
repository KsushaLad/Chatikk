package com.ladoshko.chatikk.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.ladoshko.chatikk.MainActivity
import com.ladoshko.chatikk.R

class ChangeUsernameFragment : BaseFragment(R.layout.fragment_change_username) {

    lateinit var mNewUsername: String

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as MainActivity).menuInflater.inflate(R.menu.settings_menu_confirm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_confirm_change -> changeUsername()
        }
        return true
    }

    private fun changeUsername() {

    }

}