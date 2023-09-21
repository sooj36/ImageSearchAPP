package com.example.imagesearchapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.imagesearchapp.databinding.FragmentSecondBinding
import com.example.imagesearchapp.ui.repository.Repository
import com.example.imagesearchapp.ui.viewModel.MainViewModel
import com.example.imagesearchapp.ui.viewModel.MainViewModelFactory


class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = MainViewModelFactory(Repository())
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        Log.d("sooj", "bookmark")
    }
}