package com.ladoshko.chatikk.ui.fragments

import androidx.fragment.app.Fragment
import com.ladoshko.chatikk.MainActivity

open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        (activity as MainActivity).appDrawer.disableDrawer()
    }

    override fun onStop() {
        super.onStop()
       (activity as MainActivity).appDrawer.enableDrawer()
    }

}