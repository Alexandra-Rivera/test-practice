package com.testpractice.ui.seriesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.testpractice.R
import com.testpractice.databinding.FragmentSeriesListBinding

class SeriesListFragment : Fragment() {
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

        binding.floatingActionButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_seriesListFragment_to_newSeriesFragment)
        }
    }
}