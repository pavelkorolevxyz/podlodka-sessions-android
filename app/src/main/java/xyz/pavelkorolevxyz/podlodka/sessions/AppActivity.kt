package xyz.pavelkorolevxyz.podlodka.sessions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import xyz.pavelkorolevxyz.podlodka.sessions.navigation.Destinations
import xyz.pavelkorolevxyz.podlodka.sessions.screens.main.MainScreen
import xyz.pavelkorolevxyz.podlodka.sessions.screens.sessiondetails.SessionDetailsScreen
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.PodlodkaTheme

class AppActivity : ComponentActivity() {

    private val viewModelFactory: ViewModelProvider.Factory by lazy(LazyThreadSafetyMode.NONE) {
        (application as App).component
            .mainComponent()
            .viewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavigation(
                viewModelFactory,
                onFinish = {
                    finish()
                }
            )
        }
    }
}

@Composable
private fun AppNavigation(
    viewModelFactory: ViewModelProvider.Factory,
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
                    viewModelFactory = viewModelFactory,
                    onSessionClick = { sessionId ->
                        navController.navigate(
                            "${Destinations.SessionDetails}/$sessionId"
                        )
                    },
                    onFinish = onFinish,
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
                    viewModelFactory = viewModelFactory,
                    sessionId = sessionId,
                )
            }
        }
    }
}
