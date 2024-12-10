package com.example.plantdiseasedetector.presentation.ask_Hub

import android.annotation.SuppressLint
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_medium


@Composable
fun AskQuestionListItemScreen(
    navController: NavController,
    onBackClick: () -> Unit
) {
    AskQuestionListItem(
        onBackClick = onBackClick,
        onArrowBackClick = {
            navController.popBackStack()
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AskQuestionListItem(
    onBackClick: () -> Unit,
    onArrowBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.ask_question),
                        fontFamily = quicksand_bold,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onArrowBackClick
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Ask_question"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    Button(
                        onClick = {},
                        colors = ButtonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onBackground,
                            disabledContainerColor = MaterialTheme.colorScheme.primary,
                            disabledContentColor = MaterialTheme.colorScheme.primary
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.button_send),
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                },
                containerColor = MaterialTheme.colorScheme.secondary
            )
        }
    ) {innerpadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                AddImageTextField(
                    text = stringResource(R.string.add_image_question),
                    placeholderText = stringResource(R.string.add_image_question_ph)
                )
                Spacer(modifier = Modifier.padding(8.dp))
                AddImageTextField(
                    text = stringResource(R.string.add_image_description),
                    placeholderText = stringResource(R.string.add_image_des_ph)
                )
                Spacer(modifier = Modifier.padding(8.dp))
                AddImageBox(
                    onAddImage = {}
                )
            }
        }
    }
}

@Composable
fun AddImageBox(
    onAddImage : () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {  }
            .height(100.dp)
            .background(color = MaterialTheme.colorScheme.secondary , shape = MaterialTheme.shapes.large),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add_image",
                modifier = Modifier
                    .size(35.dp)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = stringResource(R.string.add_image),
                fontFamily = quicksand_bold,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp
            )
        }
    }
}

@Composable
fun AddImageTextField(
    text: String,
    placeholderText: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            fontFamily = quicksand_bold,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(4.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            shape = MaterialTheme.shapes.medium,
            placeholder = {
                Text(
                    text = placeholderText,
                    fontFamily = quicksand_medium,
                    fontWeight = FontWeight.SemiBold,
                    )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.background,
                focusedBorderColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            singleLine = true,
        )

    }
}

@Preview
@Composable
fun AddImagePreview() {
    PlantDiseaseDetectorTheme {
    }
}