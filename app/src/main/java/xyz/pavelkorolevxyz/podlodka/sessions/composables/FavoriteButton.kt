package xyz.pavelkorolevxyz.podlodka.sessions.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import xyz.pavelkorolevxyz.podlodka.sessions.R

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onToggle: (Boolean) -> Unit = {},
) {
    IconButton(
        onClick = {
            onToggle(!isFavorite)
        }
    ) {
        when (isFavorite) {
            true -> Icon(
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = stringResource(id = R.string.favorite_remove),
                tint = Color.Red,
            )
            false -> Icon(
                painter = painterResource(id = R.drawable.ic_heart_outline),
                contentDescription = stringResource(id = R.string.favorite_add),
                tint = Color.Gray,
            )
        }
    }
}

@Preview
@Composable
private fun FavoriteButtonPreview() {
    val isFavoriteState = remember { mutableStateOf(false) }
    FavoriteButton(isFavoriteState.value) {
        isFavoriteState.value = it
    }
}
