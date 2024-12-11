package com.example.plantdiseasedetector.presentation.Knowledge

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.domain.Articles
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun KnowledgeArticleListScreen(
    navController: NavController,
    category_name: String
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
                                    text = "Search",
                                    fontFamily = quicksand_medium,
                                    fontWeight = FontWeight.SemiBold
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
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
                                contentDescription = "ArrowBack"
                            )
                        }
                    },
                    actions = {
                        DropDownMenuArticle(
                            onReadingListClick = {
                                navController.navigate(Screens.ReadingListScreenRoute.route)
                            }
                        )
                    }
                )
            } else {
                TopAppBar(
                    title = {
                        Text(
                            text = category_name,
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
                        DropDownMenuArticle(
                            onReadingListClick = {
                                navController.navigate(Screens.ReadingListScreenRoute.route)
                            }
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp , bottom = 16.dp)
        ) {
            LazyColumn {
                items(
                    items = List<Articles>(
                        size = 50,
                        init = {
                           Articles(
                               id = null,
                               article_title = "Article_title",
                               article_short_desc = "Article_Short_Description",
                               article_image = null
                           )
                        }
                    )
                ) {
                    KnowledgeArticleListItemBox(
                        title = "Article_title",
                        Description = "Article_description",
                        onArticleClick = {
                            navController.navigate(Screens.ArticleDetailScreenRoute.route)
                        }
                    )
                }
            }
        }
    }

}

@Composable
fun KnowledgeArticleListItemBox(
    onArticleClick : () -> Unit,
    title: String,
    Description: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onArticleClick()
            }
            .height(300.dp)
            .padding(12.dp)
            .border(0.1.dp , color = MaterialTheme.colorScheme.primary , shape = MaterialTheme.shapes.medium)
            .background(color = MaterialTheme.colorScheme.secondary , shape = MaterialTheme.shapes.medium)
    ) {
        Column(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
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
                TitleAndDisArticle(
                    text = title,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.padding(4.dp))
                TitleAndDisArticle(
                    text = Description,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.bookmark_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                            contentDescription = "reading_list_icon"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TitleAndDisArticle(
    text: String,
    fontWeight: FontWeight,
) {
        Text(
            text = text,
            fontFamily = quicksand_medium,
            fontWeight = fontWeight
        )
    }


@Preview(showBackground = true)
@Composable
fun Preview() {
    PlantDiseaseDetectorTheme {
    }
}