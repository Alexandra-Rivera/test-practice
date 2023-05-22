package com.arivera.testpractice.ui.serieslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arivera.testpractice.R
import com.arivera.testpractice.data.model.SeriesModel
import com.arivera.testpractice.databinding.FragmentSeriesListBinding
import com.arivera.testpractice.ui.serieslist.seriesrecyclerview.SeriesRecyclerViewAdapter
import com.arivera.testpractice.ui.seriesviewmodel.SeriesViewModel

class SeriesList : Fragment() {

//    private val seriesViewModel : SeriesViewModel by activityViewModels {
//        SeriesViewModel.Factory
//    }

//    private lateinit var adapter: SeriesRecyclerViewAdapter
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

//        setRecyclerView(view)
        binding.floatingActionButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_seriesList_to_newSeries)
        }
    }

//    private fun showSelectedItem(serie: SeriesModel) {
//        seriesViewModel.setSeriesData(serie)
//        findNavController().navigate(R.id.action_seriesList_to_seriesInformation)
//    }
//
//    private fun displaySeries() {
//        adapter.setData(seriesViewModel.getSeries())
//        adapter.notifyDataSetChanged()
//    }
//
//    private fun setRecyclerView(view: View) {
//        binding.seriesRecyclerview.layoutManager = LinearLayoutManager(view.context)
//            adapter = SeriesRecyclerViewAdapter { selectedSeries ->
//                showSelectedItem(selectedSeries)
//            }
//
//            binding.seriesRecyclerview.adapter = adapter
//
//            displaySeries()
//    }
}