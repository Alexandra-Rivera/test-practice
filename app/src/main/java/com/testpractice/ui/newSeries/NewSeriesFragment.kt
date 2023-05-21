package com.testpractice.ui.newSeries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.testpractice.databinding.FragmentNewSeriesBinding
import com.testpractice.ui.viewmodel.SeriesViewModel

class NewSeriesFragment : Fragment() {

    private val seriesViewModel: SeriesViewModel by activityViewModels {
        SeriesViewModel.Factory
    }

    private lateinit var binding: FragmentNewSeriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewSeriesBinding.inflate(inflater, container, false)
        return binding.root
    }
}