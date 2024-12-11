package com.example.plantdiseasedetector.presentation.authentication

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.presentation.Knowledge.DropDownMenuArticle
import com.example.plantdiseasedetector.presentation.Knowledge.SortingDropDownMenu
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_light
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignInScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.welcome_back),
                        fontFamily = quicksand_bold,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier

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
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {},
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonColors(
                        containerColor = Color.LightGray,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        disabledContainerColor = Color.LightGray,
                        disabledContentColor =  Color.LightGray
                    ),
                    modifier = Modifier
                        .padding(start = 24.dp , end = 24.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Icon(
                            painter = painterResource(R.drawable.google_svgrepo_com__1_),
                            contentDescription = "Google_icon",
                            tint = Color.Black,
                            modifier = Modifier
                                .size(24.dp)
                        )
                        Spacer(modifier = Modifier.padding(6.dp))
                        Text(
                            text = stringResource(R.string.google_signUp),
                            fontFamily = quicksand_bold,
                            color = Color.Black,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 15.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Button(
                    onClick = {

                    },
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        disabledContainerColor = MaterialTheme.colorScheme.primary,
                        disabledContentColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier
                        .padding(start = 24.dp , end = 24.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Icon(
                            painter = painterResource(R.drawable.smartphone_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                            contentDescription = "Google_icon"
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(
                            text = stringResource(R.string.phone_signUp),
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 15.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.signup_account_string),
                        fontFamily = quicksand_bold,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            navController.navigate(Screens.SignUpScreenRoute.route)
                        },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.signUp),
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    PlantDiseaseDetectorTheme {
    }
}

