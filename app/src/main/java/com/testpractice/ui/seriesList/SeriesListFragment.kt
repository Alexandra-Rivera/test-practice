package com.testpractice.ui.seriesList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.testpractice.databinding.FragmentSeriesListBinding
import com.testpractice.ui.viewmodel.SeriesViewModel

class SeriesListFragment : Fragment() {

    private val seriesviewmodel: SeriesViewModel by activityViewModels{
        SeriesViewModel.Factory
    }

    private lateinit var binding: FragmentSeriesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeriesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setviewmodel()
        dataObserver()
    }

    private fun setviewmodel(){
        binding.viewmodel = seriesviewmodel
    }

    private fun dataObserver(){
        seriesviewmodel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(SeriesViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                }

                status.equals(SeriesViewModel.NEWSERIE_ADDED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, seriesviewmodel.getSeries().toString())

                    seriesviewmodel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object{
        const val APP_TAG = "NEW SERIES ADDED"
    }
}