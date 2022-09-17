package com.ladoshko.chatikk.ui.fragments

import com.ladoshko.chatikk.R
import com.ladoshko.chatikk.utilits.*
import kotlinx.android.synthetic.main.fragment_change_bio.*

class ChangeBioFragment : BaseChangeFragment(R.layout.fragment_change_bio) {

    override fun onResume() {
        super.onResume()
        settings_input_bio.setText(USER.bio)
    }

    override fun change() {
        super.change()
        val newBio = settings_input_bio.text.toString()
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_BIO).setValue(newBio)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    showToast("Данные обновлены")
                    USER.bio = newBio
                    activity?.supportFragmentManager?.popBackStack()
                }
            }
    }

}