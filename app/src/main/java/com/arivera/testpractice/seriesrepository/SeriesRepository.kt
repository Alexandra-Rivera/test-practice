package com.arivera.testpractice.seriesrepository

import com.arivera.testpractice.data.model.SeriesModel

class SeriesRepository(private val seriesList: MutableList<SeriesModel>) {
    fun getSeries() = seriesList

    fun addNewSeries(newSeries: SeriesModel) = seriesList.add(newSeries)
}