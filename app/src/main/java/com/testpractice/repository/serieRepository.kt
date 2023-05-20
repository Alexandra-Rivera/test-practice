package com.testpractice.repository

import com.testpractice.modelo.SerieModel

class serieRepository(private val seriesList: MutableList<SerieModel>) {
    fun getSeries() = seriesList

    fun addSeries(newSerie: SerieModel) = seriesList.add(newSerie)
}