package com.example.plantdiseasedetector.presentation.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.presentation.Knowledge.KnowledgeScreen
import com.example.plantdiseasedetector.presentation.Profile.ProfileScreen
import com.example.plantdiseasedetector.presentation.chat_Hub.AskScreen
import com.example.plantdiseasedetector.presentation.imageDiagnosis.ImageDiagnosisScreen
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_light
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController
) {
    var bottomNavigationScreen by rememberSaveable {
        mutableStateOf(BottomNavigationScreens.ImaageDiagnosisScreenView)
    }

    var isHomeScreen by remember {
        mutableStateOf(true)
    }


    Scaffold(
        topBar = {
            if (isHomeScreen) {
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
                        DropDownMenu()
                    }
                )
            }
        },
            floatingActionButton = {
                if(isHomeScreen) {
                    FloatingActionButton(
                        onClick = {
                            navController.navigate(Screens.AiAssistantScreenRoute.route)
                        },
                        shape = MaterialTheme.shapes.medium,
                        containerColor = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .size(70.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.chat_bubble_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                            contentDescription = "ai_chat",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                                   },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.secondary
            ) {
                NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = {
                        bottomNavigationScreen = BottomNavigationScreens.ImaageDiagnosisScreenView
                    },
                    icon = {
                            Icon(
                                painter = painterResource(R.drawable.psychiatry_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                                contentDescription = null
                            )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.diagnose_crop),
                            fontFamily = quicksand_light,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    },
                    selected = bottomNavigationScreen == BottomNavigationScreens.ImaageDiagnosisScreenView
                )
                NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = {
                        bottomNavigationScreen = BottomNavigationScreens.AskScreenView
                    },
                    icon = {
                            Icon(
                                painter = painterResource(R.drawable.chat_bubble_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                                contentDescription = null
                            )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.chat_Hab),
                            fontFamily = quicksand_light,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    },
                    selected = bottomNavigationScreen == BottomNavigationScreens.AskScreenView
                )
                NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = {
                        bottomNavigationScreen = BottomNavigationScreens.KnowledgeView
                    },
                    icon = {
                            Icon(
                                painter = painterResource(R.drawable.school_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                                contentDescription = null
                            )
                           },
                    label = {
                        Text(
                            text = stringResource(R.string.knowledge_Hub),
                            fontFamily = quicksand_light,
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp
                        )
                    },
                    selected = bottomNavigationScreen == BottomNavigationScreens.KnowledgeView
                )
                NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = {
                        bottomNavigationScreen = BottomNavigationScreens.ProfileScreenView
                    },
                    icon = {
                            Icon(
                                painter = painterResource(R.drawable.account_circle_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                                contentDescription = null
                            )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.You),
                            fontFamily = quicksand_light,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    },
                    selected = bottomNavigationScreen == BottomNavigationScreens.ProfileScreenView,
                )
            }
        }
    ) { innerPadding ->
       AnimatedContent(
           targetState = bottomNavigationScreen,
           label = "",
           transitionSpec = {
               when(this.targetState) {
                   BottomNavigationScreens.ImaageDiagnosisScreenView -> slideInHorizontally(){it}.togetherWith(slideOutHorizontally(){-it})
                   BottomNavigationScreens.AskScreenView -> slideInHorizontally(){it}.togetherWith(slideOutHorizontally(){-it})
                   BottomNavigationScreens.KnowledgeView -> slideInHorizontally(){it}.togetherWith(slideOutHorizontally(){-it})
                   BottomNavigationScreens.ProfileScreenView -> slideInHorizontally(){it}.togetherWith(slideOutHorizontally(){-it})
               }
           },
           modifier = Modifier
               .background(color = MaterialTheme.colorScheme.background)
       ) {navScreen ->
           when(navScreen) {
               BottomNavigationScreens.ImaageDiagnosisScreenView -> {
                   isHomeScreen = true
                   ImageDiagnosisScreen(
                       navController = navController,
                       modifier = Modifier
                           .padding(innerPadding)
                   )
               }
               BottomNavigationScreens.AskScreenView -> {
                   isHomeScreen = false
                      AskScreen(
                          navController = navController
                      )
               }

               BottomNavigationScreens.KnowledgeView -> {
                   isHomeScreen = false
                   KnowledgeScreen(
                       navController = navController
                   )
               }

               BottomNavigationScreens.ProfileScreenView -> {
                   isHomeScreen = false
                   ProfileScreen(
                       navController = navController,
                       modifier = Modifier,
                       username = "user_name"
                   )
               }
           }
       }
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu() {
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

@Composable
fun RatingRow() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Button(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text(
                    text = "Bad",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            Spacer(modifier = Modifier.padding(2.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text(
                    text = "Average",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            Spacer(modifier = Modifier.padding(2.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text(
                    text = "Great",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}





private enum class BottomNavigationScreens{
    ImaageDiagnosisScreenView,
    AskScreenView,
    KnowledgeView,
    ProfileScreenView
}


