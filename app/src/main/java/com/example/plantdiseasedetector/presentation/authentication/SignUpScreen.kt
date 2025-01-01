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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_light
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel,
    context: MainActivity
) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var isVerificationSent by remember { mutableStateOf("") }
    var errorMessage  by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                        Text(
                            text = stringResource(R.string.join_com),
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier

                        )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigate(Screens.LanguageSelectionScreenRoute.route)
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
            Column {
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
                    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_signin))
                    LottieAnimation(
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.background)
                            .fillMaxWidth()
                            .size(300.dp)
                    )
                }
                SignUpInfo(
                    name = name,
                    phone = phone,
                    onNameChange = {name = it},
                    onPhoneChange = {phone = it},
                    onSignInClick = {
                        onSignUpIsFinished(context = context)
                        navController.popBackStack()
                        navController.navigate(Screens.SignInScreenRoute.route)
                    },
                    onSendVerificationbuttonClick = {
                        if (name.isNotEmpty() && phone.isNotEmpty()) {
                          viewModel.signUp(name  , phone) { success , message ->
                              if(success) {
                                  isVerificationSent = true.toString()
                                  onSignUpIsFinished(context = context)
                                  navController.popBackStack()
                                  navController.navigate(Screens.VerificationCodeScreenRoute.route)
                              } else {
                                  errorMessage = message
                              }
                          }
                        } else {
                            errorMessage = "please enter valid details!"
                        }
                    }
                )

                if(errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SignUpInfo(
    name: String,
    phone: String,
    onNameChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onSendVerificationbuttonClick: () -> Unit,
    onSignInClick : () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            OutlinedTextField(
                value = name,
                onValueChange = onNameChange,
                shape = MaterialTheme.shapes.small,
                label = {
                    Text(
                        text = stringResource(R.string.name_signIn_string),
                        fontFamily = quicksand_medium,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                placeholder = {
                    Row {
                        Text(
                            text = stringResource(R.string.name_signIn_string),
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
            Spacer(modifier = Modifier.padding(6.dp))
            OutlinedTextField(
                value = phone,
                onValueChange = onPhoneChange,
                shape = MaterialTheme.shapes.small,
                label = {
                    Text(
                        text = stringResource(R.string.phone_signIn_string),
                        fontFamily = quicksand_medium,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                placeholder = {
                    Row {
                        Text(
                            text = stringResource(R.string.phone_signIn_string),
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
            Spacer(modifier = Modifier.padding(4.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = stringResource(R.string.sms_verification_note_signIn),
                    fontFamily = quicksand_light,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(start = 26.dp)
                )
            }
            Spacer(modifier = Modifier.padding(6.dp))
            Button(
                onClick = onSendVerificationbuttonClick,
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
                    text = stringResource(R.string.signIn_button_string),
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.already_account_for_signIn),
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
                    onClick = onSignInClick,
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = stringResource(R.string.signIn),
                        fontFamily = quicksand_bold,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
        }
    }
}

@Composable
fun SignUpTextField(
    text: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
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

private fun onSignUpIsFinished(context: MainActivity) {
    val sharedPreferences = context.getSharedPreferences("onBoarding" , Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean("isFinished" , true)
    editor.apply()
}

@Preview
@Composable
fun SignUpScreenPreview() {
    PlantDiseaseDetectorTheme {
    }
}