package com.example.plantdiseasedetector.presentation.chat_Hub

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@Composable
fun AskListBoxScreen(
    username: String,
    title: String,
    description: String,
    navController: NavController,
    question_image: Painter
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable {
                navController.navigate(Screens.AskListBoxEditScreenRoute.route)
            }
            .background(color = MaterialTheme.colorScheme.secondary , shape = MaterialTheme.shapes.large)
            .border(0.1.dp , color = MaterialTheme.colorScheme.primary , shape = MaterialTheme.shapes.medium)
    ) {
        Column(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(156.dp)
                    .background(color = MaterialTheme.colorScheme.background , shape = MaterialTheme.shapes.medium),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = question_image,
                    contentDescription = "Image",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.padding(4.dp))
            ProfileInfo(
                username = username
            )
            Spacer(Modifier.padding(2.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 6.dp , end = 6.dp , bottom = 6.dp)
                ) {
                    TitleAndDis(
                        text = title,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                    )
                    TitleAndDis(
                        text = description,
                        fontWeight = FontWeight.ExtraLight,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
        }
    }
}


@Composable
fun ProfileInfo(
    username: String
) {
    Row(
        modifier = Modifier
            .padding(start = 5.dp)
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Profile_icon",
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = username,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = quicksand_bold,
            fontWeight = FontWeight.ExtraBold,
        )
    }
}

@Composable
fun TitleAndDis(
    text: String,
    fontWeight: FontWeight,
    modifier: Modifier
) {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = text,
            fontFamily = quicksand_medium,
            fontWeight = fontWeight,
            maxLines = 2,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun AskListBoxScreenPreview() {
    PlantDiseaseDetectorTheme {
    }
}
