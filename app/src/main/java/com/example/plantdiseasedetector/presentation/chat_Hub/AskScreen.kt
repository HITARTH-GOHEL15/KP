package com.example.plantdiseasedetector.presentation.chat_Hub

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.domain.AskQuestion
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.presentation.home.DropDownMenu
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_light
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AskScreen(
    navController: NavController
) {
    var searchBar by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            if (searchBar) {
                TopAppBar(
                    title = {
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            shape = MaterialTheme.shapes.extraLarge,
                            placeholder = {
                                Text(
                                    text = "Search...",
                                    fontFamily = quicksand_medium,
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "search"
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp),
                            singleLine = true,
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                searchBar = false
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        DropDownMenu()
                    }
                )
            } else {
                TopAppBar(
                    title = {
                        Row {
                            Text(
                                text = "Chat",
                                fontFamily = quicksand_bold,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .padding(start = 8.dp)
                            )
                            Spacer(modifier = Modifier.padding(2.dp))
                            Text(
                                text = "Hub",
                                fontFamily = quicksand_bold,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                searchBar = true
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search_iconButton"
                            )
                        }
                        SortingDropDownMenu()
                        DropDownMenu()
                    },
                )
            }
            },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screens.AskListItemScreenRoute.route)
                },
                shape = MaterialTheme.shapes.extraLarge,
                containerColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .width(170.dp)
                    .padding(bottom = 90.dp)
            ) {
                Row {
                    Icon(
                        painter = painterResource(R.drawable.edit_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                        contentDescription = "Ask_icon",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(
                        text = "Ask Question",
                        fontFamily = quicksand_medium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp , bottom = 100.dp)
        ) {
            LazyColumn {
                items(
                  items = List<AskQuestion>(
                      size = 50,
                      init = {
                          AskQuestion(
                              id = it,
                              title = "Question_title",
                              description = "Question_Description",
                              questionImage = null
                          )
                      }
                  )
                ) {
                    AskListBoxScreen(
                        username = "User_Name",
                        title = "Question_title",
                        description = "Question_Description",
                        question_image = painterResource(R.drawable.photo_camera_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun SortingDropDownMenu() {
    var expanded by remember {
        mutableStateOf(false)
    }

    val focusRequester = remember {
        FocusRequester()
    }

    IconButton(
        onClick = { expanded = true },
        modifier = Modifier
    ) {
        Icon(
            painter = painterResource(R.drawable.sort_24dp_e8eaed_fill0_wght400_grad0_opsz24),
            contentDescription = null
        )
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier
            .focusRequester(focusRequester)
            .background(color = MaterialTheme.colorScheme.secondary)
            .padding(8.dp)
    ) {
        DropdownMenuItem(
            onClick = {},
            text = {
                Text(
                    text = stringResource(R.string.sorting_name),
                    fontFamily = quicksand_light,
                    fontWeight = FontWeight.Bold
                )
            }
        )
        DropdownMenuItem(
            onClick = {},
            text = {
                Text(
                    text = stringResource(R.string.sorting_date),
                    fontFamily = quicksand_light,
                    fontWeight = FontWeight.Bold
                )
            }
        )
        DropdownMenuItem(
            onClick = {},
            text = {
                Text(
                    text = stringResource(R.string.ascending_sorting),
                    fontFamily = quicksand_light,
                    fontWeight = FontWeight.Bold
                )
            }
        )
        DropdownMenuItem(
            onClick = {},
            text = {
                Text(
                    text = stringResource(R.string.descending_sorting),
                    fontFamily = quicksand_light,
                    fontWeight = FontWeight.Bold
                )
            }
        )
    }
}







