package xyz.pavelkorolevxyz.podlodka.sessions.composables

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable

@Composable
fun BackgroundSurface(
    content: @Composable () -> Unit,
) {
    Surface(
        color = MaterialTheme.colors.background,
        content = content,
    )
}
