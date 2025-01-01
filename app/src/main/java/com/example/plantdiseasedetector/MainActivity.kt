package com.example.plantdiseasedetector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.plantdiseasedetector.data.network.UserRepository
import com.example.plantdiseasedetector.domain.KnowledgeCategory
import com.example.plantdiseasedetector.navigation.Nav
import com.example.plantdiseasedetector.presentation.authentication.SignUpViewModel
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val repository = UserRepository()
            val viewModel = SignUpViewModel(repository)
            PlantDiseaseDetectorTheme {
               Nav(
                   context = this@MainActivity,
                   signUpViewModel = viewModel
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