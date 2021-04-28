package xyz.pavelkorolevxyz.podlodka.sessions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import xyz.pavelkorolevxyz.podlodka.sessions.data.MockSessions
import xyz.pavelkorolevxyz.podlodka.sessions.navigation.Destinations
import xyz.pavelkorolevxyz.podlodka.sessions.screens.MainScreen
import xyz.pavelkorolevxyz.podlodka.sessions.screens.SessionDetailsScreen
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.PodlodkaTheme

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavigation()
        }
    }
}

@Composable
private fun AppNavigation() {
    val navController = rememberNavController()
    PodlodkaTheme {
        NavHost(
            navController = navController,
            startDestination = Destinations.Main,
        ) {
            composable(Destinations.Main) {
                MainScreen(
                    sessions = MockSessions,
                    favoriteSessions = MockSessions.take(3),
                    onSessionClick = { sessionId ->
                        navController.navigate(
                            "${Destinations.SessionDetails}/$sessionId"
                        )
                    }
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
                val sessionId =
                    backStackEntry.arguments?.getString(Destinations.SessionDetailsArgs.SessionId)
                val session = MockSessions.first { it.id == sessionId }
                SessionDetailsScreen(
                    session = session,
                )
            }
        }
    }
}

