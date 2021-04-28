package xyz.pavelkorolevxyz.podlodka.sessions.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.Medium

@Composable
fun ListHeader(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier
            .padding(
                start = Medium,
                top = Medium,
                end = Medium,
            )
            .fillMaxWidth(),
        style = MaterialTheme.typography.h4,
        text = text,
    )
}

@Preview(showBackground = true)
@Composable
private fun ListHeaderPreview() {
    ListHeader(text = "List header")
}
