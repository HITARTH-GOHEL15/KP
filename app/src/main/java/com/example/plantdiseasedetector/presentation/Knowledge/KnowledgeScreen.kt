package com.example.plantdiseasedetector.presentation.Knowledge

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun KnowledgeScreen(
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
                                text = "Knowledge",
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
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp , bottom = 100.dp)
        ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.Center
                ) {
                    items(
                        items = List<KnowledgeCategory>(
                            size = 50,
                            init = {
                                KnowledgeCategory(
                                    id = it,
                                    title = "Category_name",
                                    category_image = null
                                )
                            }
                        )
                    ) {
                        KnowledgeCategoryListBox(
                            title = "Category_name",
                            onCategoryClick = {
                                navController.navigate(Screens.KnowledgeArticleListScreenRoute.route)
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
    title: String
) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .padding(12.dp)
            .clickable {
                onCategoryClick()
            }
            .border(0.1.dp , color = MaterialTheme.colorScheme.primary , shape = MaterialTheme.shapes.medium)
            .background(color = MaterialTheme.colorScheme.secondary , shape = MaterialTheme.shapes.medium)
    ) {
            Column(
                modifier = Modifier
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .background(color = MaterialTheme.colorScheme.background , shape = MaterialTheme.shapes.medium),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.photo_camera_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.padding(4.dp))
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    TitleAndDis(
                        text = title,
                        fontWeight = FontWeight.ExtraBold
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
fun TitleAndDis(
    text: String,
    fontWeight: FontWeight,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = quicksand_medium,
            fontWeight = fontWeight
        )
    }
}

@Preview
@Composable
fun KnowledgePreview() {
    PlantDiseaseDetectorTheme {

    }
}