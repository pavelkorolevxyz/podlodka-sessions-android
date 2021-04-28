package xyz.pavelkorolevxyz.podlodka.sessions.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.Medium
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.PodlodkaTheme

@Composable
fun EmptyView(
    text: String,
    modifier: Modifier = Modifier,
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
    }
}

@Preview(showBackground = true)
@Composable
private fun EmptyViewPreview() {
    PodlodkaTheme {
        EmptyView(
            text = "No items"
        )
    }
}
