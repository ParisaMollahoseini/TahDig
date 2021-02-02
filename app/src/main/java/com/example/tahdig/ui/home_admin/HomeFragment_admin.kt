package com.example.tahdig.ui.home_admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tahdig.R

class HomeFragment_admin : Fragment() {

    private lateinit var homeViewModel: HomeViewModel_admin

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel_admin::class.java)
        val root = inflater.inflate(R.layout.fragment_home_admin, container, false)
        val textView: TextView = root.findViewById(R.id.text_home_admin)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}