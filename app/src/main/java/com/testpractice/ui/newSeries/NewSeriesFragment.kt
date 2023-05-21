package com.testpractice.ui.newSeries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.testpractice.databinding.FragmentNewSeriesBinding

class NewSeriesFragment : Fragment() {

    private lateinit var binding: FragmentNewSeriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewSeriesBinding.inflate(inflater, container, false)
        return binding.root
    }
}