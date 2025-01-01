package com.example.plantdiseasedetector.presentation.knowledge

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.data.DataSourceClimateInfo
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_light

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CropWiseDetailScreen(
    navController: NavController,
    modifier: Modifier
) {

    val selectedCategoryId = navController.previousBackStackEntry?.savedStateHandle
        ?.get<Int>("selectedCategoryId")

    val selectedCategory = selectedCategoryId?.let { id ->
        DataSourceClimateInfo().loadClimateInfo().find { it.id == id }
    }

    selectedCategory?.let { knowledgeCategory ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = LocalContext.current.getString(knowledgeCategory.title),
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier
                                .padding(start = 14.dp)
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "ArrowBack"
                            )
                        }
                    },
                    actions = {
                        DropDownMenuArticle(
                            onReadingListClick = {
                                navController.navigate(Screens.ReadingListScreenRoute.route)
                            }
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )
                )
            },
        ) {paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.secondary)
                    .padding(start = 12.dp , top = 100.dp , end = 12.dp , bottom = 16.dp)
            ) {
                item {
                    Text(
                        text = stringResource(R.string.article_image),
                        fontFamily = quicksand_bold,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                }
                item {
                    Spacer(modifier = Modifier.padding(4.dp))
                    CropImage(
                        articleImage = painterResource(knowledgeCategory.category_image),
                        modifier = Modifier
                    )
                }
                item {
                    Spacer(
                        modifier = Modifier.padding(10.dp)
                    )
                    CropDetails(
                        climate = LocalContext.current.getString(knowledgeCategory.climateInfo),
                        diseases1 = LocalContext.current.getString(knowledgeCategory.disease1Info),
                        diseases1_prevention = LocalContext.current.getString(knowledgeCategory.disease1Prevention),
                        diseases2 = LocalContext.current.getString(knowledgeCategory.disease2Info),
                        diseases2_prevention = LocalContext.current.getString(knowledgeCategory.disease2Prevention),
                    )
                }
            }
        }
    }
}


@Composable
fun CropImage(
    articleImage: Painter,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(200.dp)
            .background(color = MaterialTheme.colorScheme.background)
            .border(0.5.dp , color = Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = articleImage,
            contentDescription = "Article_image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
fun CropDetails(
    climate: String,
    diseases1: String,
    diseases1_prevention: String,
    diseases2: String,
    diseases2_prevention: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column() {
            Column() {
                Text(
                    text = "Climate & Soil:",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.Bold
                )
                CropText(
                    text = climate,
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.padding(6.dp))
            Column {
                Text(
                    text = "Diseases1:",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(6.dp))
                CropText(
                    text = diseases1,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(6.dp))
                Text(
                    text = "Prevention:",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.Bold
                )
                CropText(
                    text = diseases1_prevention,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(6.dp))
                Text(
                    text = "Diseases2:",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(6.dp))
                CropText(
                    text = diseases2,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(6.dp))
                Text(
                    text = "Prevention:",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.Bold
                )
                CropText(
                    text = diseases2_prevention,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun CropText(
    text: String,
    modifier: Modifier
) {
    Text(
        text = text,
        fontFamily = quicksand_light,
        fontWeight = FontWeight.Light,
        modifier = Modifier
            .padding(start = 8.dp)
    )
}

@Composable
fun DropDownMenuArticle(
    onReadingListClick: () -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    var focusRequester = remember {
        FocusRequester()
    }

    IconButton(
        onClick = { expanded = true },
        modifier = Modifier
    ) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null
        )
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {expanded = false},
        modifier = Modifier
            .focusRequester(focusRequester)
            .background(color = MaterialTheme.colorScheme.secondary)
            .padding(8.dp)
    ) {
        DropdownMenuItem(
            onClick = onReadingListClick,
            text = {
                Text(
                    text = stringResource(R.string.bookMark),
                    fontFamily = quicksand_light,
                    fontWeight = FontWeight.Bold
                )
            }
        )
    }
}

@Preview
@Composable
fun ArticleDetailScreenPreview() {
    PlantDiseaseDetectorTheme {

    }
}