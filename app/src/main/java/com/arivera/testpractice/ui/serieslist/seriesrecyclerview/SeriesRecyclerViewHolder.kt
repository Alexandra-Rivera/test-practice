package com.arivera.testpractice.ui.serieslist.seriesrecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.arivera.testpractice.data.model.SeriesModel
import com.arivera.testpractice.databinding.SeriesListItemBinding

class SeriesRecyclerViewHolder(private val binding: SeriesListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(serie: SeriesModel, clickListener: (SeriesModel) -> Unit){
        binding.seriesName.text = serie.name
        binding.seriesGenre.text = serie.genre

        binding.seriesCardview.setOnClickListener{
            clickListener(serie)
        }
    }
}