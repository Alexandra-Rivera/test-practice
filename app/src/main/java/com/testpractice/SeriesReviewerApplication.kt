package com.testpractice

import android.app.Application
import com.testpractice.data.modelo.serie
import com.testpractice.repository.SerieRepository

class SeriesReviewerApplication: Application() {
    val SerieRepository: SerieRepository by lazy {
        SerieRepository(serie)
    }
}