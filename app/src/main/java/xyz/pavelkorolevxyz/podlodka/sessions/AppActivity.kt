package xyz.pavelkorolevxyz.podlodka.sessions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import xyz.pavelkorolevxyz.podlodka.sessions.data.MockSessions
import xyz.pavelkorolevxyz.podlodka.sessions.screens.MainScreen
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.PodlodkaTheme

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PodlodkaTheme {
                MainScreen(
                    sessions = MockSessions,
                    favoriteSessions = MockSessions.take(3),
                )
            }
        }
    }
}
