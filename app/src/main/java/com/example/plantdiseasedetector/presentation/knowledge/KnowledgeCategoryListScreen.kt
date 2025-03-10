package com.example.plantdiseasedetector.presentation.knowledge

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.domain.KnowledgeCategory
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.presentation.home.DropDownMenu
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_light
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun KnowledgeCategoryListScreen(
    knowledgeOfflineInfo: List<KnowledgeCategory>,
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
                                text = "Offline",
                                fontFamily = quicksand_bold,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 18.sp,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .padding(start = 8.dp)
                            )
                            Spacer(modifier = Modifier.padding(2.dp))
                            Text(
                                text = "Knowledge",
                                fontFamily = quicksand_bold,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
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
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp , bottom = 20.dp)
        ) {
                LazyColumn(
                    state = LazyListState()
                ) {
                    items(
                       knowledgeOfflineInfo
                    ) {knowledgeCategory ->
                        KnowledgeCategoryListBox(
                            title = LocalContext.current.getString(knowledgeCategory.title),
                            painter = painterResource(knowledgeCategory.category_image),
                            onCategoryClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    "selectedCategoryId",
                                    knowledgeCategory.id
                                )
                                navController.navigate(Screens.ArticleDetailScreenRoute.route)
                            },
                            onArrowClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    "selectedCategoryId",
                                    knowledgeCategory.id
                                )
                                navController.navigate(Screens.ArticleDetailScreenRoute.route)
                            }
                        )
                    }
                }
            }
        }
    }



@Composable
fun KnowledgeCategoryListBox(
    onCategoryClick: () -> Unit,
    onArrowClick: () -> Unit,
    painter: Painter,
    title: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(12.dp)
            .clickable {
                onCategoryClick()
            }
            .border(0.1.dp , color = MaterialTheme.colorScheme.primary)
            .background(color = MaterialTheme.colorScheme.secondary)
    ) {
            Row(
                modifier = Modifier
            ) {
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .background(color = MaterialTheme.colorScheme.background),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painter,
                        contentDescription = "Image",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Column(
                    modifier = Modifier
                        .padding(top = 34.dp)
                ) {
                    TitleAndArrow(
                        text = title,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier,
                        onArrowClick = onArrowClick
                    )
                }
            }
        }
    }

@Composable
fun SortingDropDownMenu() {
    var expanded by remember {
        mutableStateOf(false)
    }

    var focusRequester = remember {
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


@Composable
fun TitleAndArrow(
    text: String,
    fontWeight: FontWeight,
    onArrowClick: () -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = text,
                fontFamily = quicksand_medium,
                fontWeight = fontWeight
            )
            Spacer(modifier = Modifier.padding(12.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 34.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                IconButton(
                    onClick = onArrowClick
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

@Preview
@Composable
fun KnowledgePreview() {
    PlantDiseaseDetectorTheme {
    }
}