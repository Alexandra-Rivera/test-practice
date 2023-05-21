package com.testpractice.ui.viewmodel

import android.text.Spannable.Factory
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.testpractice.SeriesReviewerApplication
import com.testpractice.data.modelo.SerieModel
import com.testpractice.repository.SerieRepository
import com.testpractice.ui.seriesList.SeriesListFragment

class SeriesViewModel(private val serieRepository: SerieRepository): ViewModel() {
    val name = MutableLiveData("")
    val genre = MutableLiveData("")
    val status = MutableLiveData("")

    fun getSeries() = serieRepository.getSeries()

     fun createNewSerie(){
        if (!dataValidation()){
            status.value = WRONG_INFORMATION
        }
        val newSerie = SerieModel(name.value!!, genre.value!!)
        serieRepository.addSeries(newSerie)

        clearData()

        status.value = NEWSERIE_ADDED
    }

    private fun dataValidation(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            genre.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData(){
        name.value = ""
        genre.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as SeriesReviewerApplication
                SeriesViewModel(app.SerieRepository)
            }
        }
        const val NEWSERIE_ADDED = "Serie aniadida"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""
    }

}