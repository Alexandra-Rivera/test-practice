package com.testpractice.ui.viewmodel

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.testpractice.SeriesReviewerApplication
import com.testpractice.modelo.SerieModel
import com.testpractice.modelo.serie
import com.testpractice.repository.SerieRepository
import com.testpractice.ui.seriesList.SeriesListFragment

class SeriesViewModel(private var seriesRepository: SerieRepository): ViewModel() {
    fun getSeries() = seriesRepository.getSeries()

    fun addSeries(newSerie: SerieModel) = seriesRepository.addSeries(newSerie)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as SeriesReviewerApplication
                SeriesViewModel(app.SerieRepository)
            }
        }
    }
}