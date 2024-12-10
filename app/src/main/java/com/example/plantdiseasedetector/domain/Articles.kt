package com.example.plantdiseasedetector.domain

import androidx.compose.ui.graphics.painter.Painter

data class Articles(
    val id: Int?,
    val article_title: String,
    val article_short_desc: String,
    val article_image: Painter?
)
