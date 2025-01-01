package com.example.plantdiseasedetector.presentation.imageDiagnosis

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.navigation.Screens
import com.example.plantdiseasedetector.ui.theme.PlantDiseaseDetectorTheme
import com.example.plantdiseasedetector.ui.theme.quicksand_bold
import com.example.plantdiseasedetector.ui.theme.quicksand_light
import com.example.plantdiseasedetector.ui.theme.quicksand_medium

@Composable
fun ImageDiagnosisScreen(
    navController: NavController,
    modifier: Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        OutlinedTextField(
//                value = "",
//                onValueChange = {},
//                shape = MaterialTheme.shapes.extraLarge,
//                placeholder = {
//                    Text(
//                        text = "Direct Search",
//                        fontFamily = quicksand_medium,
//                    )
//                },
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = "search"
//                    )
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 20.dp , end = 20.dp , bottom = 8.dp),
//            )
        Text(
            text = stringResource(R.string.heal_Crop),
            fontFamily = quicksand_medium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        CropBox(
            onButtonClick = {
                navController.navigate(Screens.DiagnosisReportScreenRoute.route)
            },
            modifier = Modifier
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Instructions()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 160.dp , start = 12.dp , end = 12.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Column {
                Text(
                    text = "Available Subsidies :",
                    fontFamily = quicksand_bold,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 2.dp)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                SubsidyScreen(
                    navController = navController
                )
            }
        }
    }
}


@Composable
fun CropBox(
    onButtonClick: () -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondary , shape = MaterialTheme.shapes.medium)
                .clickable {  }
                .padding(start = 16.dp , end = 16.dp)
                .height(170.dp)
                .width(300.dp)
        ) {
            Row(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 25.dp)
            ) {
                InstructionIconsItem(
                    painter = painterResource(R.drawable.crop_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                    icontext = "Take a picture"
                )
                Icon(
                    painter = painterResource(R.drawable.arrow_forward_ios_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                    contentDescription = "Arrow_forward",
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
                InstructionIconsItem(
                    painter = painterResource(R.drawable.diagnosis_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                    icontext = "See diagnosis"
                )
                Icon(
                    painter = painterResource(R.drawable.arrow_forward_ios_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                    contentDescription = "Arrow_forward",
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
                InstructionIconsItem(
                    painter = painterResource(R.drawable.medication_liquid_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                    icontext = "Get medicine"
                )
            }
            Button(
                onClick = onButtonClick,
                colors = ButtonDefaults.textButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(50.dp)
                    .padding(10.dp)
            ) {
                Text(
                    text = "Take a picture",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = quicksand_medium,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}

@Composable
fun InstructionIconsItem(
    painter: Painter,
    icontext: String
) {
    Box() {
        Column {
            Icon(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .size(35.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = icontext,
                fontFamily = quicksand_light,
                fontWeight = FontWeight.SemiBold,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun Instructions() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp)
    ) {
        Text(
            text = "Instructions :",
            fontFamily = quicksand_bold,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = stringResource(R.string.instruction_1),
            fontFamily = quicksand_light,
            fontWeight = FontWeight.Bold,
            fontSize = 7.sp
        )
        Text(
            text = stringResource(R.string.instruction_2),
            fontFamily = quicksand_light,
            fontWeight = FontWeight.Bold,
            fontSize = 7.sp
        )
        Text(
            text = stringResource(R.string.instruction_3),
            fontFamily = quicksand_light,
            fontWeight = FontWeight.Bold,
            fontSize = 7.sp
        )
    }
}

@Preview
@Composable
fun ImageDiagnosisPreview() {
    PlantDiseaseDetectorTheme {

    }
}