package com.example.imagesearchapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentFirstBinding




    class FirstFragment : Fragment() {
        private lateinit var binding : FragmentFirstBinding

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentFirstBinding.inflate(inflater, container, false)
            return binding.root
        }

    }