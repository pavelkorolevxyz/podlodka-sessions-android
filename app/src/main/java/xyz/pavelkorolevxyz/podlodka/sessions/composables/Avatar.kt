package xyz.pavelkorolevxyz.podlodka.sessions.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.transform.CircleCropTransformation
import com.google.accompanist.coil.rememberCoilPainter
import xyz.pavelkorolevxyz.podlodka.sessions.R
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.PodlodkaTheme

@Composable
fun Avatar(
    imageUrl: String?,
    modifier: Modifier = Modifier,
    contentDescription: String?,
) {
    val placeholder = R.drawable.ic_avatar_placeholder
    val imagePainter = rememberCoilPainter(
        request = imageUrl,
        previewPlaceholder = placeholder,
        fadeIn = true,
        requestBuilder = {
            placeholder(placeholder)
            fallback(placeholder)
            error(placeholder)
            transformations(CircleCropTransformation())
        },
    )
    Image(
        modifier = modifier,
        painter = imagePainter,
        contentDescription = contentDescription,
    )
}

@Preview
@Composable
private fun AvatarPreview() {
    PodlodkaTheme {
        Avatar(
            imageUrl = null,
            contentDescription = null,
        )
    }
}
