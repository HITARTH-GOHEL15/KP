package com.example.plantdiseasedetector.presentation.ask_Hub

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.presentation.home.DropDownMenu
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AskListBoxEditScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
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
                    DropDownMenu()
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            shape = MaterialTheme.shapes.extraLarge,
                            placeholder = {
                                Box(
                                    modifier = Modifier,
                                    contentAlignment = Alignment.Center
                                ) {
                                        Text(
                                            text = "Write your comment",
                                            fontFamily = quicksand_medium,
                                            fontWeight = FontWeight.SemiBold,
                                            modifier = Modifier
                                        )
                                }
                            },
                            modifier = Modifier
                                .height(50.dp)
                                .width(350.dp),
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "send",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                },
                containerColor = MaterialTheme.colorScheme.secondary
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(start = 12.dp, top = 90.dp , end = 12.dp)
        ) {
            Column() {
                AskListBoxScreen(
                    username = "user_1",
                    title = "question title",
                    description = "question desc.",
                    question_image = painterResource(R.drawable.photo_camera_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                    navController = navController
                )
                Spacer(modifier = Modifier.padding(6.dp))
                Text(
                    text = "Comments : ",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 2.dp)
                    )
            }
        }
    }
}

@Preview
@Composable
fun AskListBoxEditScreenPreview() {
    PlantDiseaseDetectorTheme {
    }
}

