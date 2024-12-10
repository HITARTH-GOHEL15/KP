package com.example.plantdiseasedetector.presentation.Knowledge

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_light

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ArticleDetailScreen(
    navController: NavController,
    article_name : String
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = article_name,
                        fontFamily = quicksand_bold,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .padding(start = 14.dp)
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
        },
    ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.secondary)
                    .padding(start = 12.dp , top = 100.dp , end = 12.dp)
            ) {
                Text(
                    text = stringResource(R.string.article_image),
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .padding(start = 8.dp)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                ArticleImage(
                    articleImage = painterResource(R.drawable.photo_camera_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = stringResource(R.string.article_desc),
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(8.dp)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                ArticleDis(
                    articleDes = "Article Description",
                    modifier = Modifier
                )
            }
        }

    }


@Composable
fun ArticleImage(
    articleImage: Painter,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(200.dp)
            .background(color = MaterialTheme.colorScheme.background , shape = MaterialTheme.shapes.medium)
            .border(0.5.dp , color = Color.LightGray , shape = MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = articleImage,
            contentDescription = "Article_image",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ArticleDis(
    articleDes: String,
    modifier: Modifier
) {
    Text(
        text = articleDes,
        fontFamily = quicksand_bold,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .padding(start = 8.dp)
    )
}

@Composable
fun DropDownMenuArticle(
    onReadingListClick: () -> Unit
) {
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
            onClick = onReadingListClick,
            text = {
                Text(
                    text = stringResource(R.string.bookMark),
                    fontFamily = quicksand_light,
                    fontWeight = FontWeight.Bold
                )
            }
        )
    }
}

@Preview
@Composable
fun ArticleDetailScreenPreview() {
    PlantDiseaseDetectorTheme {

    }
}