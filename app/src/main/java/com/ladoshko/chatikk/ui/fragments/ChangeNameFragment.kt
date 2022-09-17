package com.ladoshko.chatikk.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.ladoshko.chatikk.MainActivity
import com.ladoshko.chatikk.R
import com.ladoshko.chatikk.utilits.*
import kotlinx.android.synthetic.main.fragment_change_name.*

class ChangeNameFragment : BaseChangeFragment(R.layout.fragment_change_name) {

    override fun onResume() {
        super.onResume()
       // setHasOptionsMenu(true)
        val fullNameList = USER.fullname.split(" ")
        if (fullNameList.size > 1){
            settings_input_name.setText(fullNameList[0])
            settings_input_surname.setText(fullNameList[1])
        } else {
            settings_input_name.setText(fullNameList[0])
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        (activity as MainActivity).menuInflater.inflate(R.menu.settings_menu_confirm, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//       when(item.itemId){
//           R.id.settings_confirm_change -> changeName()
//       }
//        return true
//    }

    override fun change() {
        val name = settings_input_name.text.toString()
        val surname = settings_input_surname.text.toString()
        if (name.isEmpty()) {
            showToast("Введите имя")
        } else {
            val fullname = "$name $surname"
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_FULLNAME).setValue(fullname).addOnCompleteListener(){
                if (it.isSuccessful){
                    showToast("Данные обновлены")
                    USER.fullname= fullname
                    activity?.supportFragmentManager?.popBackStack()
                }
            }
        }
    }

}