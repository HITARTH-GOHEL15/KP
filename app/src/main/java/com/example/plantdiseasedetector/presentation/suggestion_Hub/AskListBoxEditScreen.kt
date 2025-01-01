package com.example.plantdiseasedetector.presentation.suggestion_Hub

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.presentation.home.DropDownMenu
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_light
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
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            )
        },
    ) {
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondary)
                .fillMaxSize()
                .padding(start = 12.dp, top = 90.dp , end = 12.dp)
        ) {
            PostDetails(
                posttitle = "post_title",
                postDes = "post_description",
                modifier = Modifier
            )
        }
    }
}

@Composable
fun PostDetails(
    posttitle: String,
    postDes: String,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        LazyColumn (
            modifier = Modifier
        ) {
            item {
                Text(
                    text = "Post image :",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.ExtraBold
                )

            }
            item {
                Spacer(modifier = Modifier.padding(8.dp))
                PostImage(
                    PostImage = painterResource(R.drawable.photo_camera_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                )
            }
            item {
                Spacer(modifier = Modifier.padding(12.dp))
                Text(
                    text = "Title :",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.padding(4.dp))
                PostTitleAndDes(
                    posttext = posttitle
                )
                Spacer(modifier = Modifier.padding(12.dp))
                Text(
                    text = "Description :",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.padding(4.dp))
                PostTitleAndDes(
                    posttext = postDes
                )
            }
        }
    }
}

@Composable
fun PostTitleAndDes(
    posttext: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = posttext,
            fontFamily = quicksand_light,
            fontWeight = FontWeight.Light
        )
    }
}

@Composable
fun PostImage(
    PostImage: Painter,
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
            painter = PostImage,
            contentDescription = "Post_image",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Preview
@Composable
fun AskListBoxEditScreenPreview() {
    PlantDiseaseDetectorTheme {
    }
}

