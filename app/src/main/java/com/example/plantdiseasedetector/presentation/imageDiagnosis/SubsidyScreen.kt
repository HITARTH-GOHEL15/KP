package com.example.plantdiseasedetector.presentation.imageDiagnosis

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.OnReceiveContentViewBehavior
import androidx.navigation.NavController
import com.example.plantdiseasedetector.domain.AskQuestion
import com.example.plantdiseasedetector.domain.Subsidys
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_light
import com.example.plantdiseasedetector.ui.theme.quicksand_medium
import kotlinx.coroutines.channels.ticker

@Composable
fun SubsidyScreen(
    navController: NavController
) {
    LazyRow {
        items(
            items = List<Subsidys>(
                size = 20,
                init = {
                    Subsidys(
                        id = it,
                        subTitle = "Subsidy_title",
                        subEligibility = "Subsidy_Eligibility",
                        subStatus = "Subsidy_status"
                    )
                }
            )
        ) {
            SubsidyScreenListBox(
                subTitle = "Subsidy_title",
                onViewClick = {
                    navController.navigate(Screens.SubsidyDetailScreenRoute.route)
                }
            )
        }

    }
}


@Composable
fun SubsidyScreenListBox(
    subTitle: String,
    onViewClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .padding(8.dp)
            .background(color = MaterialTheme.colorScheme.secondary , shape = MaterialTheme.shapes.medium)
            .height(100.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp , end = 6.dp , top = 6.dp)
        ) {
                SubText(
                    text = subTitle
                )
            Spacer(modifier = Modifier.padding(4.dp))
            Button(
                    onClick = onViewClick,
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier
                        .padding(start = 35.dp)
                        .width(100.dp)
                ) {
                    Text(
                        text = "View",
                        fontFamily = quicksand_medium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }

@Composable
fun SubText(
    text: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = quicksand_light,
            fontWeight = FontWeight.Light
        )
    }
}

@Preview
@Composable
fun SubsidyScreenPreview() {
    PlantDiseaseDetectorTheme {
    }
}

