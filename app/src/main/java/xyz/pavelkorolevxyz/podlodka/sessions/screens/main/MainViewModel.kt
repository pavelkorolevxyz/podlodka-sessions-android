package xyz.pavelkorolevxyz.podlodka.sessions.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import xyz.pavelkorolevxyz.podlodka.sessions.data.FavoriteRepository
import xyz.pavelkorolevxyz.podlodka.sessions.data.Session
import xyz.pavelkorolevxyz.podlodka.sessions.data.SessionRepository
import java.io.IOException
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val sessionRepository: SessionRepository,
    private val favoriteRepository: FavoriteRepository,
) : ViewModel() {

    private val _sessionsFlow: MutableStateFlow<List<Session>> = MutableStateFlow(emptyList())
    val sessionsFlow: Flow<List<Session>> get() = _sessionsFlow

    private val _favoritesFlow: MutableStateFlow<Set<String>> = MutableStateFlow(emptySet())
    val favoritesFlow: Flow<Set<String>> get() = _favoritesFlow

    private val _loadingFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loadingFlow: Flow<Boolean> get() = _loadingFlow

    private val _isErrorFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isErrorFlow: Flow<Boolean> get() = _isErrorFlow

    private val _isShowExitConfirmationFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isShowExitConfirmationFlow: Flow<Boolean> get() = _isShowExitConfirmationFlow

    private val _isFavoriteErrorFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isFavoriteErrorFlow: Flow<Boolean> get() = _isFavoriteErrorFlow

    init {
        loadFavorites()
        loadSessions()
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            val favorites = favoriteRepository.getFavoriteSet()
            _favoritesFlow.emit(favorites)
        }
    }

    private fun loadSessions() {
        viewModelScope.launch {
            _loadingFlow.value = true
            try {
                val sessions = sessionRepository.getSessions()
                _sessionsFlow.emit(sessions)
                _isErrorFlow.emit(false)
            } catch (e: IOException) {
                _isErrorFlow.emit(true)
            }
            _loadingFlow.value = false
        }
    }

    fun onReload() {
        loadSessions()
    }

    fun onSessionFavoriteToggle(sessionId: String, isFavorite: Boolean) {
        val favoriteSuccess = favoriteRepository.setFavorite(sessionId, isFavorite)
        viewModelScope.launch {
            if (!favoriteSuccess) {
                _isFavoriteErrorFlow.emit(true)
                delay(300)
                _isFavoriteErrorFlow.emit(false)
                return@launch
            }
            loadFavorites()
        }
    }

    fun onBackClick() {
        viewModelScope.launch {
            _isShowExitConfirmationFlow.emit(true)
        }
    }

    fun onExitDecline() {
        viewModelScope.launch {
            _isShowExitConfirmationFlow.emit(false)
        }
    }
}
