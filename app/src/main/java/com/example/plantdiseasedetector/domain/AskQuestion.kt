package com.example.plantdiseasedetector.domain

import androidx.compose.ui.graphics.painter.Painter

data class AskQuestion(
    val id: Int?,
    val title: String,
    val description: String,
    val questionImage: Painter?
)
