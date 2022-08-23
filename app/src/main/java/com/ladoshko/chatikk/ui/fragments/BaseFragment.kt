package com.ladoshko.chatikk.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open class BaseFragment(val layout: Int) : Fragment() {

    private lateinit var mRoot: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRoot = inflater.inflate(layout, container, false)
        return mRoot
    }

    override fun onStart() {
        super.onStart()
    }

}