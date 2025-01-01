package com.example.plantdiseasedetector.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.painter.Painter

data class KnowledgeCategory(
    val id: Int?,
    @StringRes val title: Int,
    @StringRes val climateInfo: Int,
    @StringRes val soilInfo: Int,
    @StringRes val disease1Info: Int,
    @StringRes val disease1Prevention: Int,
    @StringRes val disease2Info: Int,
    @StringRes val disease2Prevention: Int,
    @DrawableRes val category_image: Int
)
