package com.example.plantdiseasedetector.presentation.knowledge

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.presentation.home.DropDownMenu
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun KnowledgeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            text = "Knowledge",
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .padding(start = 8.dp)
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(
                            text = "Hub",
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier
                        )
                    }
                },
                actions = {
                    DropDownMenu()
                },
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(start = 12.dp , top = 100.dp , end = 12.dp , bottom = 100.dp),
        ) {
            LazyColumn {
                item {
                    OnlineKnowledgeHubBox()
                }
                item {
                    OfflineKnowledgeHubBox(
                        onOfflineKnowledgeHubBox = {
                            navController.navigate(Screens.KnowledgeCategoryListScreenRoute.route)
                        }
                    )
                }
            }
        }
    }
}


@SuppressLint("ResourceType")
@Composable
fun OfflineKnowledgeHubBox(
    onOfflineKnowledgeHubBox : () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onOfflineKnowledgeHubBox()
            }
            .height(380.dp)
            .padding(12.dp)
            .border(0.1.dp , color = MaterialTheme.colorScheme.primary , shape = MaterialTheme.shapes.medium)
            .background(color = MaterialTheme.colorScheme.secondary , shape = MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
        ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(
                            color = MaterialTheme.colorScheme.background,
                            shape = MaterialTheme.shapes.medium
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_offline))
                    LottieAnimation(
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.secondary)
                            .fillMaxWidth()
                            .size(400.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Offline Knowledge Hub",
                        fontFamily = quicksand_bold,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }

@Composable
fun OnlineKnowledgeHubBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
            }
            .height(380.dp)
            .padding(12.dp)
            .border(0.1.dp , color = MaterialTheme.colorScheme.primary , shape = MaterialTheme.shapes.medium)
            .background(color = MaterialTheme.colorScheme.secondary , shape = MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = MaterialTheme.shapes.medium
                    ),
                contentAlignment = Alignment.Center
            ) {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_online))
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.secondary)
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                        .size(400.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Online Knowledge Hub",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    modifier = Modifier
                )
            }
        }
    }
}


@Preview
@Composable
fun KnowledgeScreenPreview() {
    PlantDiseaseDetectorTheme {
        OnlineKnowledgeHubBox()
    }
}