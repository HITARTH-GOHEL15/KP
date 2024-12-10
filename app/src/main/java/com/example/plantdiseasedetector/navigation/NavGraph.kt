package com.example.plantdiseasedetector.navigation

import android.view.animation.Animation
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.presentation.Knowledge.ArticleDetailScreen
import com.example.plantdiseasedetector.presentation.Knowledge.KnowledgeArticleListScreen
import com.example.plantdiseasedetector.presentation.Knowledge.KnowledgeScreen
import com.example.plantdiseasedetector.presentation.Knowledge.ReadingListScreen
import com.example.plantdiseasedetector.presentation.Profile.ProfileScreen
import com.example.plantdiseasedetector.presentation.ask_Hub.AskListBoxEditScreen
import com.example.plantdiseasedetector.presentation.ask_Hub.AskListBoxScreen
import com.example.plantdiseasedetector.presentation.ask_Hub.AskQuestionListItemScreen
import com.example.plantdiseasedetector.presentation.ask_Hub.AskScreen
import com.example.plantdiseasedetector.presentation.authentication.SignInScreen
import com.example.plantdiseasedetector.presentation.authentication.SignUpScreen
import com.example.plantdiseasedetector.presentation.home.HomeScreen
import com.example.plantdiseasedetector.presentation.imageDiagnosis.AiAssistantScreen
import com.example.plantdiseasedetector.presentation.imageDiagnosis.DiagnosisReportScreen
import com.example.plantdiseasedetector.presentation.imageDiagnosis.ImageDiagnosisScreen

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController ,
        startDestination = Screens.HomeScreenRoute.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(100)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(100)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(100)
            )
        }
    ) {


        // Home
        composable(
            Screens.HomeScreenRoute.route
        ) {
            HomeScreen(
                navController = navController
            )
        }
        // Profile-auth Nested Navigation Graph
        navigation(
            startDestination = Screens.ProfileScreenRoute.route,
            route = Screens.UserRoute.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(100)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(100)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(100)
                )
            }
        ) {
            composable(
                route = Screens.ProfileScreenRoute.route
            ) {
                ProfileScreen(
                    navController = navController,
                    modifier = Modifier,
                    username = "user_name",
                )
            }
            composable(
                route = Screens.SignInScreenRoute.route
            ) {
                SignInScreen(
                    navController = navController
                )
            }
            composable(
                route = Screens.SignUpScreenRoute.route,
                ) {
                SignUpScreen(
                    navController = navController
                )
            }
        }

        // chat_hub nested navigation graph
        navigation(
            startDestination = Screens.AskScreenRoute.route,
            route = Screens.Chat_hub.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(100)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(100)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(100)
                )
            }
        ) {
            // question - list
            composable(
                route = Screens.AskScreenRoute.route,
            ) {
                AskScreen(
                    navController = navController
                )
            }
            // questions box
            composable(
                route = Screens.AskListBoxScreenRoute.route,
            ) {
                AskListBoxScreen(
                    username = "User_name",
                    navController = navController,
                    title = "Question_title",
                    description = "Question_description",
                    question_image = painterResource(R.drawable.photo_camera_24dp_e8eaed_fill0_wght400_grad0_opsz24)
                )
            }
            // question - comment
            composable(
                route = Screens.AskListBoxEditScreenRoute.route,
            ) {
                AskListBoxEditScreen(
                    navController = navController
                )
            }
            // questions - details
            composable(
                route = Screens.AskListItemScreenRoute.route,
            ) {
                AskQuestionListItemScreen(
                    navController = navController,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }

        // knowledge_hub nested navigation graph
        navigation(
            startDestination = Screens.KnowledgeScreenRoute.route,
            route = Screens.Knowledge_hub.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(100)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(100)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(100)
                )
            }
        ) {
            composable(route = Screens.KnowledgeScreenRoute.route) {
                KnowledgeScreen(
                    navController = navController
                )
            }
            composable(route = Screens.KnowledgeArticleListScreenRoute.route) {
                KnowledgeArticleListScreen(
                    navController = navController,
                    category_name = "category_name"
                )
            }
            composable(route = Screens.ArticleDetailScreenRoute.route) {
                ArticleDetailScreen(
                    navController = navController,
                    article_name = "article_name"
                )
            }
            composable(route = Screens.ReadingListScreenRoute.route) {
                ReadingListScreen(
                    navController = navController
                )
            }
        }

        // Image Diagnosis
        navigation(
            startDestination = Screens.ImageDiagnosisRoute.route,
            route = Screens.CropRoute.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(100)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(100)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(100)
                )
            }
        ) {
            composable(Screens.ImageDiagnosisRoute.route) {
                ImageDiagnosisScreen(
                    navController = navController,
                    modifier = Modifier
                )
            }
            composable(Screens.DiagnosisReportScreenRoute.route) {
                DiagnosisReportScreen(
                    navController = navController,
                    modifier = Modifier
                )
            }
            composable(Screens.AiAssistantScreenRoute.route) {
                AiAssistantScreen(
                    navController = navController
                )
            }

        }
    }
}