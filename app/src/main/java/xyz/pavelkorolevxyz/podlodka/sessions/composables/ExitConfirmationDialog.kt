package xyz.pavelkorolevxyz.podlodka.sessions.composables

import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import xyz.pavelkorolevxyz.podlodka.sessions.R

@Composable
fun ExitConfirmationDialog(
    onPositiveClick: () -> Unit = {},
    onNegativeClick: () -> Unit = {},
) {
    AlertDialog(
        title = {
            Text(
                style = MaterialTheme.typography.body1,
                text = stringResource(id = R.string.exit_confirmation),
            )
        },
        onDismissRequest = onNegativeClick,
        confirmButton = {
            TextButton(onClick = onPositiveClick) {
                Text(
                    text = stringResource(id = R.string.yes),
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onNegativeClick) {
                Text(
                    text = stringResource(id = R.string.cancel),
                )
            }
        },
    )
}

@Preview
@Composable
private fun ExitConfirmationDialogPreview() {
    ExitConfirmationDialog()
}
