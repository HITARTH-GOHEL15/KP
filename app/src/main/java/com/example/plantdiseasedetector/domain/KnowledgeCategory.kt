package com.example.plantdiseasedetector.domain

import androidx.compose.ui.graphics.painter.Painter

data class KnowledgeCategory(
    val id: Int?,
    val title: String,
    val category_image: Painter?
)
