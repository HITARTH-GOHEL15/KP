package com.example.plantdiseasedetector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.plantdiseasedetector.navigation.Nav
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlantDiseaseDetectorTheme {
               Nav(
                   context = this@MainActivity
               )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlantDiseaseDetectorTheme {

    }
}