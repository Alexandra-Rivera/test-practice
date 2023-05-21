package com.testpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.testpractice.databinding.FragmentSeriesInfoBinding

class SeriesInfoFragment : Fragment() {

    private lateinit var binding: FragmentSeriesInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeriesInfoBinding.inflate(inflater, container, false)
        return binding.root
    }
}