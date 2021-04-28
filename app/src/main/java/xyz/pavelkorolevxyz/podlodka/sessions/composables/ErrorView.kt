package xyz.pavelkorolevxyz.podlodka.sessions.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import xyz.pavelkorolevxyz.podlodka.sessions.R
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.Medium
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.PodlodkaTheme

@Composable
fun ErrorView(
    text: String,
    modifier: Modifier = Modifier,
    onReloadClick: () -> Unit = {},
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(Medium),
    ) {
        Text(
            text = text,
        )
        Spacer(
            modifier = Modifier.height(Medium),
        )
        Button(
            onClick = onReloadClick,
        ) {
            Text(
                stringResource(id = R.string.reload)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ErrorViewPreview() {
    PodlodkaTheme {
        ErrorView(
            text = "Oops",
        ) {}
    }
}
