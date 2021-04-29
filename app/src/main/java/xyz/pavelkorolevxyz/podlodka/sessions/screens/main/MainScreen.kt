package xyz.pavelkorolevxyz.podlodka.sessions.screens.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import xyz.pavelkorolevxyz.podlodka.sessions.R
import xyz.pavelkorolevxyz.podlodka.sessions.composables.BackgroundSurface
import xyz.pavelkorolevxyz.podlodka.sessions.composables.EmptyView
import xyz.pavelkorolevxyz.podlodka.sessions.composables.ErrorView
import xyz.pavelkorolevxyz.podlodka.sessions.composables.ExitConfirmationDialog
import xyz.pavelkorolevxyz.podlodka.sessions.composables.FavoriteSessionCard
import xyz.pavelkorolevxyz.podlodka.sessions.composables.ListDateHeader
import xyz.pavelkorolevxyz.podlodka.sessions.composables.ListHeader
import xyz.pavelkorolevxyz.podlodka.sessions.composables.Loader
import xyz.pavelkorolevxyz.podlodka.sessions.composables.SearchTextField
import xyz.pavelkorolevxyz.podlodka.sessions.composables.SessionCard
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.Medium
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.Small

@Composable
fun MainScreen(
    viewModelFactory: ViewModelProvider.Factory,
    searchQuery: String = "",
    onSessionClick: (String) -> Unit = {},
    onFinish: () -> Unit = {},
) {
    val viewModel: MainViewModel = viewModel(factory = viewModelFactory)

    val scaffoldState = rememberScaffoldState()
    val snackbarCoroutineScope = rememberCoroutineScope()

    BackHandler(onBack = {
        viewModel.onBackClick()
    })
    BackgroundSurface {
        val isFavoriteErrorState = viewModel.isFavoriteErrorFlow.collectAsState(initial = false)
        Scaffold(
            scaffoldState = scaffoldState,
        ) {
            if (isFavoriteErrorState.value) {
                val snackbarMessage = stringResource(id = R.string.favorite_add_error)
                snackbarCoroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(message = snackbarMessage)
                }
            }
            val searchQueryState = rememberSaveable { mutableStateOf(searchQuery) }
            val sessionsState = viewModel.sessionsFlow.collectAsState(initial = null)
            val favoritesSetState = viewModel.favoritesFlow.collectAsState(initial = emptySet())
            val isLoadingState = viewModel.loadingFlow.collectAsState(initial = false)
            val isErrorState = viewModel.isErrorFlow.collectAsState(initial = false)
            val isShowExitConfirmationState = viewModel.isShowExitConfirmationFlow
                .collectAsState(initial = false)

            if (isShowExitConfirmationState.value) {
                ExitConfirmationDialog(
                    onPositiveClick = onFinish,
                    onNegativeClick = {
                        viewModel.onExitDecline()
                    },
                )
            }
            LazyColumn(
                contentPadding = PaddingValues(bottom = Medium),
            ) {
                item {
                    SearchTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Medium),
                        text = searchQueryState,
                        onTextChanged = { query ->
                            searchQueryState.value = query
                        }
                    )
                }
                if (isLoadingState.value) {
                    item {
                        Loader()
                    }
                    return@LazyColumn
                }
                if (isErrorState.value) {
                    item {
                        ErrorView(
                            text = stringResource(id = R.string.session_error),
                            onReloadClick = {
                                viewModel.onReload()
                            }
                        )
                    }
                    return@LazyColumn
                }
                val sessions = sessionsState.value ?: return@LazyColumn
                val favoritesSet = favoritesSetState.value
                val favoriteSessions = sessions.filter { it.id in favoritesSet }
                if (favoriteSessions.isNotEmpty()) {
                    item {
                        ListHeader(
                            text = stringResource(id = R.string.favorite)
                        )
                    }
                    item {
                        LazyRow(
                            contentPadding = PaddingValues(Medium),
                            horizontalArrangement = Arrangement.spacedBy(Small)
                        ) {
                            items(favoriteSessions) { session ->
                                FavoriteSessionCard(
                                    session = session,
                                    onClick = { onSessionClick(session.id) },
                                )
                            }
                        }
                    }
                }
                val filteredSessions = sessions.filter { session ->
                    val query = searchQueryState.value
                    query.isBlank() ||
                        session.speaker.contains(query, ignoreCase = true) ||
                        session.description.contains(query, ignoreCase = true)
                }
                if (filteredSessions.isEmpty()) {
                    item {
                        EmptyView(
                            text = stringResource(id = R.string.session_not_found)
                        )
                    }
                    return@LazyColumn
                }
                item {
                    ListHeader(
                        text = stringResource(id = R.string.sessions)
                    )
                }
                var prevSessionDate: String? = null
                for (session in filteredSessions) {
                    if (prevSessionDate != session.date) {
                        item {
                            ListDateHeader(
                                text = session.date,
                            )
                        }
                        prevSessionDate = session.date
                    }
                    item {
                        SessionCard(
                            modifier = Modifier.padding(
                                start = Medium,
                                top = Medium,
                                end = Medium,
                            ),
                            session = session,
                            isFavorite = session.id in favoritesSet,
                            onFavoriteToggle = { isFavorite ->
                                viewModel.onSessionFavoriteToggle(
                                    session.id,
                                    isFavorite,
                                )
                            },
                            onClick = { onSessionClick(session.id) },
                        )
                    }
                }
            }
        }
    }
}
