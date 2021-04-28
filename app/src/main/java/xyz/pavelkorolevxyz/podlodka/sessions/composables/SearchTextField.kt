package xyz.pavelkorolevxyz.podlodka.sessions.composables

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import xyz.pavelkorolevxyz.podlodka.sessions.R

@Composable
fun SearchTextField(
    text: State<String>,
    modifier: Modifier = Modifier,
    onTextChanged: (String) -> Unit = {},
) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = modifier,
        singleLine = true,
        value = text.value,
        onValueChange = onTextChanged,
        placeholder = {
            Text(
                text = stringResource(id = R.string.search),
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
            )
        },
        trailingIcon = {
            if (text.value.isEmpty()) return@OutlinedTextField

            IconButton(
                onClick = {
                    onTextChanged("")
                },
            ) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = stringResource(id = R.string.search_clear),
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search,
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                focusManager.clearFocus()
            },
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchTextFieldPreview() {
    val searchQueryState = remember {
        mutableStateOf("Query")
    }
    SearchTextField(text = searchQueryState) {}
}
