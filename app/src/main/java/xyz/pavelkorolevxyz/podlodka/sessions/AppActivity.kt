package xyz.pavelkorolevxyz.podlodka.sessions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import xyz.pavelkorolevxyz.podlodka.sessions.navigation.Destinations
import xyz.pavelkorolevxyz.podlodka.sessions.screens.main.MainScreen
import xyz.pavelkorolevxyz.podlodka.sessions.screens.main.MainViewModel
import xyz.pavelkorolevxyz.podlodka.sessions.screens.sessiondetails.SessionDetailsScreen
import xyz.pavelkorolevxyz.podlodka.sessions.screens.sessiondetails.SessionDetailsViewModel
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.PodlodkaTheme

class AppActivity : ComponentActivity() {

    private val mainComponent by lazy {
        (application as App).component.mainComponent()
    }

    private val mainViewModel: MainViewModel by viewModels {
        mainComponent.viewModelFactory()
    }

    private val sessionDetailsViewModel: SessionDetailsViewModel by viewModels {
        mainComponent.viewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavigation(
                mainViewModel,
                sessionDetailsViewModel,
            ) {
                finish()
            }
        }
    }
}

@Composable
private fun AppNavigation(
    mainViewModel: MainViewModel,
    sessionDetailsViewModel: SessionDetailsViewModel,
    onFinish: () -> Unit = {},
) {
    val navController = rememberNavController()
    PodlodkaTheme {
        NavHost(
            navController = navController,
            startDestination = Destinations.Main,
        ) {
            composable(Destinations.Main) {
                MainScreen(
                    mainViewModel,
                    onSessionClick = { sessionId ->
                        navController.navigate(
                            "${Destinations.SessionDetails}/$sessionId"
                        )
                    },
                    onReloadClick = {
                        mainViewModel.onReload()
                    },
                    onSessionFavoriteToggle = { sessionId, isFavorite ->
                        mainViewModel.onSessionFavoriteToggle(sessionId, isFavorite)
                    },
                    onBackClick = {
                        mainViewModel.onBackClick()
                    },
                    onExitDecline = {
                        mainViewModel.onExitDecline()
                    },
                    onFinish = onFinish
                )
            }
            composable(
                "${Destinations.SessionDetails}/{${Destinations.SessionDetailsArgs.SessionId}}",
                arguments = listOf(
                    navArgument(Destinations.SessionDetailsArgs.SessionId) {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val sessionId = backStackEntry.arguments
                    ?.getString(Destinations.SessionDetailsArgs.SessionId)
                    ?: throw IllegalArgumentException("Session Id should be provided")
                SessionDetailsScreen(
                    viewModel = sessionDetailsViewModel,
                    sessionId = sessionId,
                )
            }
        }
    }
}
