package com.example.plantdiseasedetector.presentation.Profile

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.presentation.authentication.SignInScreen
import com.example.plantdiseasedetector.presentation.home.DropDownMenu
import com.example.plantdiseasedetector.presentation.home.RatingRow
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_light
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    username: String,
    navController: NavController,
    modifier: Modifier
) {
    var showFeedbackDialog by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Plant",
                                fontFamily = quicksand_medium,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.ExtraBold
                            )
                            Spacer(modifier = Modifier.padding(4.dp))
                            Text(
                                text = "Detector",
                                fontFamily = quicksand_medium,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    },
                    actions = {
                        ProfileDropDownMenu()
                    }
                )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(start = 8.dp, top = 120.dp , end = 8.dp)
                .fillMaxSize()
        ) {
            UserInfoBox(
                modifier = Modifier,
                username = username,
                onSignUpButtonClick = {
                    navController.navigate(Screens.SignInScreenRoute.route)
                }
            )
            Spacer(modifier = Modifier.padding(40.dp))
            FeedBackBox(
                onFeedBackButtonClick = {
                    showFeedbackDialog = true
                }
            )
        }
    }
    //feedback dialog
    if(showFeedbackDialog) {
        BasicAlertDialog(
            onDismissRequest = {
                showFeedbackDialog = false
            },
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background , shape = MaterialTheme.shapes.medium)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Text(
                    text = stringResource(R.string.feedback_string),
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.padding(4.dp))
                RatingRow()
                Spacer(modifier = Modifier.padding(6.dp))
                Button(
                    onClick = {},
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        disabledContainerColor = MaterialTheme.colorScheme.primary,
                        disabledContentColor =  MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier
                        .padding(start = 24.dp , end = 24.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Text(
                            text = "submit",
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 15.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(4.dp))
                Button(
                    onClick = {},
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        disabledContainerColor = MaterialTheme.colorScheme.secondary,
                        disabledContentColor =  MaterialTheme.colorScheme.secondary
                    ),
                    modifier = Modifier
                        .padding(start = 24.dp , end = 24.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Text(
                            text = "cancel",
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FeedBackBox(
    onFeedBackButtonClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.secondary , shape = MaterialTheme.shapes.medium)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.reviews_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                contentDescription = "feedback_icon",
                modifier = Modifier
                    .padding(start = 6.dp , top = 9.dp)
            )
            Spacer(modifier = Modifier.padding(14.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                FeedbackTextAndButton(
                    text = stringResource(R.string.feedback_box_text1),
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(3.dp))
                FeedbackTextAndButton(
                    text = stringResource(R.string.feedback_box_text2),
                    fontWeight = FontWeight.ExtraLight,
                    modifier = Modifier
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Button(
                        onClick = onFeedBackButtonClick,
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.give_feedback),
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FeedbackTextAndButton(
    text: String,
    fontWeight: FontWeight,
    modifier: Modifier
) {
    Text(
        text = text,
        fontFamily = quicksand_medium,
        fontWeight = fontWeight,
        modifier = Modifier
    )
}





@Composable
fun UserInfoBox(
    onSignUpButtonClick : () -> Unit,
    username: String,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .clickable {  }
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            UserPic(
                user_image = painterResource(R.drawable.account_circle_24dp_e8eaed_fill0_wght400_grad0_opsz24)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            UserTitleAndEdit(
                username = username,
                modifier = Modifier,
                onSignUpButtonClick = onSignUpButtonClick
            )
        }
    }
}

@Composable
fun UserTitleAndEdit(
    onSignUpButtonClick : () -> Unit,
    username: String,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(
                text = username,
                fontFamily = quicksand_bold,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(start = 6.dp)
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = stringResource(R.string.join_com),
                fontFamily = quicksand_light,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(start = 6.dp)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Button(
                onClick = onSignUpButtonClick,
                colors = ButtonDefaults.textButtonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "sign up",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

@Composable
fun UserPic(
    user_image: Painter
) {
    Box(
        modifier = Modifier
            .height(130.dp)
            .width(130.dp)
            .background(color = MaterialTheme.colorScheme.secondary , shape = MaterialTheme.shapes.small)
    ) {
        Image(
            painter = user_image,
            contentDescription = "user_image",
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground),
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDropDownMenu() {
    var expanded by remember {
        mutableStateOf(false)
    }

    var focusRequester = remember {
        FocusRequester()
    }

    var showFeedbackDialog by remember {
        mutableStateOf(false)
    }

    var showReportDialog by remember {
        mutableStateOf(false)
    }



    IconButton(
        onClick = { expanded = true },
        modifier = Modifier
    ) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null
        )
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {expanded = false},
        modifier = Modifier
            .focusRequester(focusRequester)
            .background(color = MaterialTheme.colorScheme.secondary)
            .padding(8.dp)
    ) {
        DropdownMenuItem(
            onClick = {
                showFeedbackDialog = true
            },
            text = {
                Text(
                    text = stringResource(R.string.feedback),
                    fontFamily = quicksand_light,
                    fontWeight = FontWeight.Bold
                )
            }
        )
        DropdownMenuItem(
            onClick = {
                showReportDialog = true
            },
            text = {
                Text(
                    text = stringResource(R.string.report_issue),
                    fontFamily = quicksand_light,
                    fontWeight = FontWeight.Bold
                )
            }
        )
        DropdownMenuItem(
            onClick = {

            },
            text = {
                Text(
                    text = "Sign Out",
                    fontFamily = quicksand_light,
                    fontWeight = FontWeight.Bold
                )
            }
        )
        DropdownMenuItem(
            onClick = {

            },
            text = {
                Text(
                    text = "Delete Account",
                    fontFamily = quicksand_light,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.error
                )
            }
        )
    }

    //feedback dialog
    if(showFeedbackDialog) {
        BasicAlertDialog(
            onDismissRequest = {
                showFeedbackDialog = false
            },
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background , shape = MaterialTheme.shapes.medium)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Text(
                    text = stringResource(R.string.feedback_string),
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.padding(4.dp))
                RatingRow()
                Spacer(modifier = Modifier.padding(6.dp))
                Button(
                    onClick = {},
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        disabledContainerColor = MaterialTheme.colorScheme.primary,
                        disabledContentColor =  MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier
                        .padding(start = 24.dp , end = 24.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Text(
                            text = "submit",
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 15.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(4.dp))
                Button(
                    onClick = {},
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        disabledContainerColor = MaterialTheme.colorScheme.secondary,
                        disabledContentColor =  MaterialTheme.colorScheme.secondary
                    ),
                    modifier = Modifier
                        .padding(start = 24.dp , end = 24.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Text(
                            text = "cancel",
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }

    //report issue dialog
    if(showReportDialog) {
        BasicAlertDialog(
            onDismissRequest = {
                showReportDialog = false
            },
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background , shape = MaterialTheme.shapes.medium)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Text(
                    text = stringResource(R.string.report_string),
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.padding(8.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    shape = MaterialTheme.shapes.small,
                    placeholder = {
                        Row {
                            Text(
                                text = "Write about your issues",
                                fontFamily = quicksand_medium,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp , end = 24.dp),
                )
                Spacer(modifier = Modifier.padding(6.dp))
                Button(
                    onClick = {},
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        disabledContainerColor = MaterialTheme.colorScheme.secondary,
                        disabledContentColor =  MaterialTheme.colorScheme.secondary
                    ),
                    modifier = Modifier
                        .padding(start = 24.dp , end = 24.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Text(
                            text = "report",
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 15.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(4.dp))
                Button(
                    onClick = {},
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        disabledContainerColor = MaterialTheme.colorScheme.primary,
                        disabledContentColor =  MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier
                        .padding(start = 24.dp , end = 24.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Text(
                            text = "cancel",
                            fontFamily = quicksand_bold,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    PlantDiseaseDetectorTheme {
    }
}

