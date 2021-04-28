package xyz.pavelkorolevxyz.podlodka.sessions.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.CardElevation

/**
 * [Card] doesn't clip ripple by its shape :(
 *
 * [StackOverflow](https://stackoverflow.com/q/66820206/552246)
 */
@Composable
fun ClickableCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    Card(
        elevation = CardElevation,
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier.clickable(onClick = onClick),
            content = content,
        )
    }
}
