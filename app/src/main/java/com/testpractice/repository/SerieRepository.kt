package com.testpractice.repository

import com.testpractice.data.modelo.SerieModel

class SerieRepository(private val seriesList: MutableList<SerieModel>) {
    fun getSeries() = seriesList

    fun addSeries(newSerie: SerieModel) = seriesList.add(newSerie)
}