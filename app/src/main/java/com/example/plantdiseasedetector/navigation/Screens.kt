package com.example.plantdiseasedetector.navigation

sealed class Screens(val route: String) {
    //splash
    data object SplashScreenRoute : Screens(route = "Splash")
    //onboarding
    data object OnboardingScreenRoute : Screens(route = "OnBoard")
    //home
    data object HomeScreenRoute : Screens(route = "home")
    //Auth
    data object ProfileScreenRoute : Screens(route = "editProfile")
    data object SignInScreenRoute : Screens(route = "SignIn")
    data object SignUpScreenRoute : Screens(route = "SignUp")
    data object UserRoute: Screens(route = "User")
    //chat_hub
    data object AskListBoxEditScreenRoute : Screens(route = "questions_comments")
    data object AskListBoxScreenRoute : Screens(route = "questions")
    data object AskListItemScreenRoute : Screens(route = "questions_details")
    data object AskScreenRoute : Screens(route = "questions_list")
    data object Chat_hub : Screens(route = "chat_hub")
    //knowledge_hub
    data object KnowledgeScreenRoute : Screens(route = "category_list")
    data object KnowledgeArticleListScreenRoute : Screens(route = "article_list")
    data object ArticleDetailScreenRoute :   Screens("article_details")
    data object ReadingListScreenRoute : Screens("reading_list")
    data object Knowledge_hub : Screens("knowledge_hub")
    //image Diagnosis
    data object DiagnosisReportScreenRoute : Screens(route = "report_diagnosis")
    data object ImageDiagnosisRoute : Screens(route = "image_diagnosis")
    data object AiAssistantScreenRoute : Screens(route = "ai_assistant")
    data object CropRoute : Screens(route = "crop")

}