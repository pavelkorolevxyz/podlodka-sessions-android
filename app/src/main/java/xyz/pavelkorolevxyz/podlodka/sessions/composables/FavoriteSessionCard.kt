package xyz.pavelkorolevxyz.podlodka.sessions.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.pavelkorolevxyz.podlodka.sessions.data.MockSession
import xyz.pavelkorolevxyz.podlodka.sessions.data.Session
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.PodlodkaTheme
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.Small

private val FavoriteSessionCardSize = 128.dp

@Composable
fun FavoriteSessionCard(
    session: Session,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    ClickableCard(
        modifier = modifier
            .size(FavoriteSessionCardSize),
        onClick = onClick,
    ) {
        Column(modifier = Modifier.padding(Small)) {
            Text(
                style = MaterialTheme.typography.h4,
                text = session.timeInterval,
            )
            Text(
                style = MaterialTheme.typography.subtitle2,
                text = session.date,
            )
            Spacer(
                modifier = Modifier.weight(1f),
            )
            Text(
                style = MaterialTheme.typography.h5,
                text = session.speaker,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                style = MaterialTheme.typography.subtitle2,
                text = session.description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview
@Composable
private fun FavoriteSessionCardPreview() {
    PodlodkaTheme {
        FavoriteSessionCard(session = MockSession)
    }
}

@Preview
@Composable
private fun FavoriteSessionCardDarkPreview() {
    PodlodkaTheme(isDarkTheme = true) {
        FavoriteSessionCard(session = MockSession)
    }
}
