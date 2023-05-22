package com.arivera.testpractice.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.arivera.testpractice.R
import com.arivera.testpractice.databinding.FragmentSeriesInformationBinding
import com.arivera.testpractice.ui.seriesviewmodel.SeriesViewModel

class SeriesInformation : Fragment() {

    private val seriesViewModel: SeriesViewModel by activityViewModels {
        SeriesViewModel.Factory
    }
    private lateinit var binding: FragmentSeriesInformationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeriesInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = seriesViewModel
        binding.beforeButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_seriesInformation_to_seriesList)
        }
    }
}