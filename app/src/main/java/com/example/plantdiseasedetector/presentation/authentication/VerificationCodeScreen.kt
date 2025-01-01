package com.example.plantdiseasedetector.presentation.authentication

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.plantdiseasedetector.MainActivity
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationCodeScreen(
    navController: NavController,
    context: MainActivity
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                        Text(
                            text = "join our app",
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier

                        )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigate(Screens.SignUpScreenRoute.route)
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
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .background(
                            color = MaterialTheme.colorScheme.background,
                            shape = MaterialTheme.shapes.medium
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_vc))
                    LottieAnimation(
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.background)
                            .fillMaxWidth()
                            .size(300.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(14.dp))
                VerificationTextField(
                    text = "Enter verification code"
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Button(
                    onClick = {
                        onVerificationCodeIsFinished(context = context)
                        navController.popBackStack()
                        navController.navigate(Screens.HomeScreenRoute.route)
                              },
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
                    Text(
                        text = "Send",
                        fontFamily = quicksand_bold,
                        fontWeight = FontWeight.Light,
                        fontSize = 15.sp
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Text(
                            text = "Request new verification code",
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
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

private fun onVerificationCodeIsFinished(context: MainActivity) {
    val sharedPreferences = context.getSharedPreferences("onBoarding" , Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean("isFinished" , true)
    editor.apply()
}

@Composable
fun VerificationTextField(
    text: String,
) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        shape = MaterialTheme.shapes.small,
        label = {
            Text(
                text = text,
                fontFamily = quicksand_medium,
                fontWeight = FontWeight.SemiBold
            )
        },
        placeholder = {
            Row {
                Text(
                    text = text,
                    fontFamily = quicksand_medium,
                    fontWeight = FontWeight.SemiBold
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp , end = 24.dp),
        singleLine = true,
    )
}