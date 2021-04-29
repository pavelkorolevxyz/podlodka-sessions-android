package xyz.pavelkorolevxyz.podlodka.sessions.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.pavelkorolevxyz.podlodka.sessions.data.MockSession
import xyz.pavelkorolevxyz.podlodka.sessions.data.Session
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.Medium
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.PodlodkaTheme

private val AvatarSize = 60.dp

@Composable
fun SessionCard(
    session: Session,
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
    onFavoriteToggle: (Boolean) -> Unit = {},
    onClick: () -> Unit = {},
) {
    ClickableCard(
        modifier = modifier
            .fillMaxWidth(),
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier.padding(Medium),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Avatar(
                modifier = Modifier.size(AvatarSize),
                imageUrl = session.imageUrl,
                contentDescription = session.speaker,
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = Medium),
            ) {
                Text(
                    style = MaterialTheme.typography.h5,
                    text = session.speaker,
                )
                Text(
                    style = MaterialTheme.typography.h5,
                    text = session.timeInterval,
                )
                Text(
                    style = MaterialTheme.typography.subtitle2,
                    text = session.description,
                )
            }

            FavoriteButton(
                isFavorite = isFavorite,
                onToggle = onFavoriteToggle
            )
        }
    }
}

@Preview
@Composable
private fun SessionCardPreview() {
    PodlodkaTheme {
        SessionCard(
            session = MockSession,
        )
    }
}

@Preview
@Composable
private fun SessionCardDarkPreview() {
    PodlodkaTheme(isDarkTheme = true) {
        SessionCard(
            session = MockSession,
        )
    }
}
