package com.example.plantdiseasedetector.presentation.onBoarding

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.plantdiseasedetector.MainActivity
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.domain.languages
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@Composable
fun LanguageselectionScreen(
    navController: NavController,
    languages: List<languages>,
    context: MainActivity
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.secondary),
    ) {
        item {
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
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_language))
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.secondary)
                        .fillMaxWidth()
                        .size(300.dp)
                )
            }
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Select Your Language!",
                    fontFamily = quicksand_bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp
                )
            }
            Spacer(modifier = Modifier.padding(20.dp))
        }
        items(
            languages
        ) {
            LanguageselectionListBox(
                language = LocalContext.current.getString(it.languages)
            )
        }
        item {
            Spacer(modifier = Modifier.padding(12.dp))
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                OutlinedButton(
                    onClick = {
                        onlanguageSelectionIsFinished(context = context)
                        navController.popBackStack()
                        navController.navigate(Screens.SignUpScreenRoute.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        text = "Get Started",
                        fontSize = 22.sp,
                        fontFamily = quicksand_bold,
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}


@Composable
fun LanguageselectionListBox(
    language : String
) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp , end = 20.dp , bottom = 20.dp)
                .height(100.dp)
                .background(color = MaterialTheme.colorScheme.primary , shape = MaterialTheme.shapes.medium),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = language,
                    fontFamily = quicksand_bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .padding(top = 12.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Arrow_right"
                        )
                    }
                }
            }
        }
    }

private fun onlanguageSelectionIsFinished(context: MainActivity) {
    val sharedPreferences = context.getSharedPreferences("onBoarding" , Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean("isFinished" , true)
    editor.apply()
}

@Preview
@Composable
fun LanguageSelectionScreenPreview() {
    PlantDiseaseDetectorTheme {

    }
}