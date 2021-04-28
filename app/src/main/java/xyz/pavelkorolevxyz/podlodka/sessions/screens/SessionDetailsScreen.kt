package xyz.pavelkorolevxyz.podlodka.sessions.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.pavelkorolevxyz.podlodka.sessions.composables.Avatar
import xyz.pavelkorolevxyz.podlodka.sessions.composables.BackgroundSurface
import xyz.pavelkorolevxyz.podlodka.sessions.composables.DateTimeText
import xyz.pavelkorolevxyz.podlodka.sessions.data.MockSessions
import xyz.pavelkorolevxyz.podlodka.sessions.data.Session
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.Medium
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.PodlodkaTheme

@Composable
fun SessionDetailsScreen(session: Session) {
    BackgroundSurface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(Medium),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(Medium),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Avatar(
                    modifier = Modifier.size(234.dp),
                    imageUrl = session.imageUrl,
                    contentDescription = null,
                )
                Text(
                    style = MaterialTheme.typography.h3,
                    text = session.speaker,
                )
                DateTimeText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "${session.date}, ${session.timeInterval}",
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.body1,
                    text = session.description,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SessionDetailsScreenPreview() {
    PodlodkaTheme {
        SessionDetailsScreen(session = MockSessions.first())
    }
}

@Preview(showBackground = true)
@Composable
private fun SessionDetailsScreenDarkPreview() {
    PodlodkaTheme(isDarkTheme = true) {
        SessionDetailsScreen(session = MockSessions.first())
    }
}