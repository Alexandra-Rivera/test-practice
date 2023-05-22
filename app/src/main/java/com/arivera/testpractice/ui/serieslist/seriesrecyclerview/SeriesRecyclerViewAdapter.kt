package com.arivera.testpractice.ui.serieslist.seriesrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arivera.testpractice.data.model.SeriesModel
import com.arivera.testpractice.databinding.SeriesListItemBinding

class SeriesRecyclerViewAdapter(private var clickListener: (SeriesModel) -> Unit) : RecyclerView.Adapter<SeriesRecyclerViewHolder>(){
    private val seriesArray = ArrayList<SeriesModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesRecyclerViewHolder {
        val binding = SeriesListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeriesRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return seriesArray.size
    }

    override fun onBindViewHolder(holder: SeriesRecyclerViewHolder, position: Int) {
        val createdSerie = seriesArray[position]
        holder.bind(createdSerie, clickListener)
    }

    fun setData(serieList: List<SeriesModel>) {
        seriesArray.clear()
        seriesArray.addAll(serieList.reversed())
    }

}