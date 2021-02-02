package com.example.tahdig.ui.slideshow_admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tahdig.R

class SlideshowFragment_admin : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel_admin

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel_admin::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow_admin, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow_admin)
        slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}