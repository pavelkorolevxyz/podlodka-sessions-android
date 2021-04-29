package xyz.pavelkorolevxyz.podlodka.sessions.screens.sessiondetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.pavelkorolevxyz.podlodka.sessions.composables.Avatar
import xyz.pavelkorolevxyz.podlodka.sessions.composables.BackgroundSurface
import xyz.pavelkorolevxyz.podlodka.sessions.composables.DateTimeText
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.Medium

@Composable
fun SessionDetailsScreen(
    viewModel: SessionDetailsViewModel,
    sessionId: String,
) {
    viewModel.onLoad(sessionId = sessionId)
    BackgroundSurface {
        val sessionState = viewModel.sessionFlow.collectAsState(initial = null)
        val session = sessionState.value ?: return@BackgroundSurface
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
