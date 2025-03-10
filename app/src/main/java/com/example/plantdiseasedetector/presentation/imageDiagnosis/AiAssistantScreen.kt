package com.example.plantdiseasedetector.presentation.imageDiagnosis

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.presentation.home.DropDownMenu
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AiAssistantScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "AI Assistant",
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
                    DropDownMenu()
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        shape = MaterialTheme.shapes.extraLarge,
                        placeholder = {
                            Box(
                                modifier = Modifier,
                                contentAlignment = Alignment.Center
                            ) {
                                    Text(
                                        text = "Ask a question",
                                        fontFamily = quicksand_medium,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier
                                    )
                                }
                        },
                        modifier = Modifier
                            .width(330.dp),
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    IconButton(
                        onClick = {},
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.mic_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                            contentDescription = "Mic",
                            modifier = Modifier.size(30.dp),
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                containerColor = MaterialTheme.colorScheme.secondary
            )
        }
    ) {

    }
}