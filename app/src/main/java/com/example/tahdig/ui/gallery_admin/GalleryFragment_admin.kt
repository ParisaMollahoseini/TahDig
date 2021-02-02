package com.example.tahdig.ui.gallery_admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tahdig.R

class GalleryFragment_admin : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel_admin

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel_admin::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery_admin, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery_admin)
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}