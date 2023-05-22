package com.arivera.testpractice

import android.app.Application
import com.arivera.testpractice.data.model.seriesList
import com.arivera.testpractice.seriesrepository.SeriesRepository

class SeriesReviewerApplication: Application() {
    val seriesRepository: SeriesRepository by lazy {
        SeriesRepository(seriesList)
    }
}