package com.arivera.testpractice.ui.newseries

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.arivera.testpractice.databinding.FragmentNewSeriesBinding
import com.arivera.testpractice.ui.seriesviewmodel.SeriesViewModel

class NewSeries : Fragment() {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        statusObserver()
    }

    private fun setViewModel() {
        binding.viewmodel = seriesViewModel
    }

    private fun statusObserver() {
        seriesViewModel.status.observe(viewLifecycleOwner){ status ->
            when{
                status.equals(SeriesViewModel.CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, seriesViewModel.getSeries().toString())

                    seriesViewModel.clearStatus()
                    findNavController().popBackStack()
                }

                status.equals(SeriesViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    seriesViewModel.clearStatus()
                }
            }
        }
    }

    companion object {
        const val APP_TAG = "APP_TAG"
    }
}