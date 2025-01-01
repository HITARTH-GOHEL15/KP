package com.example.plantdiseasedetector.data

import androidx.compose.ui.res.stringResource
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.domain.languages

class DataSourcelanguage {
    fun loadLanguageInfo() : List<languages> {
        return listOf<languages>(
            languages(
                id = 1,
                languages = R.string.english
            ),
            languages(
                id = 2,
                languages = R.string.hindi
            ),
            languages(
                id = 3,
                languages = R.string.gujarati
            )
        )
    }
}