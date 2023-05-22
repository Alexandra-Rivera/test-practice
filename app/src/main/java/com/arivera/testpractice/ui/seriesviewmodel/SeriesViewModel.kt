package com.arivera.testpractice.ui.seriesviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.arivera.testpractice.SeriesReviewerApplication
import com.arivera.testpractice.data.model.SeriesModel
import com.arivera.testpractice.seriesrepository.SeriesRepository

class SeriesViewModel(private val seriesRepository: SeriesRepository): ViewModel() {
    val name = MutableLiveData("")
    val genre = MutableLiveData("")
    val sinopsis = MutableLiveData("")
    var status = MutableLiveData("")

    fun createNewSeries(){
        if (!dataValidation()){
            clearData()
            status.value = WRONG_INFORMATION
        }

        val newSeries = SeriesModel(name.value!!, genre.value!!, sinopsis.value!!)
        seriesRepository.addNewSeries(newSeries)

        clearData()

        status.value = CREATED
    }

    private fun dataValidation(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            genre.value.isNullOrEmpty() -> return false
            sinopsis.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData(){
        name.value = ""
        genre.value = ""
        sinopsis.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun getSeries() = seriesRepository.getSeries()

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as SeriesReviewerApplication
                SeriesViewModel(app.seriesRepository)
            }
        }
        const val CREATED = "New series created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = "Inactive"
    }

    fun setSelectedSerie(serie: SeriesModel) {
        name.value = serie.name
        genre.value = serie.genre
        sinopsis.value = serie.sinopsis
    }
}