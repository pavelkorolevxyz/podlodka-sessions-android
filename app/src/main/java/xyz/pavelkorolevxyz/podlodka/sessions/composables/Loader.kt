package xyz.pavelkorolevxyz.podlodka.sessions.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.Medium
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.PodlodkaTheme

private val LoaderSize = 56.dp

@Composable
fun Loader(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(Medium),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(LoaderSize),
        )
    }
}

@Preview
@Composable
private fun LoaderPreview() {
    PodlodkaTheme {
        Loader()
    }
}
