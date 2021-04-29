package xyz.pavelkorolevxyz.podlodka.sessions.screens.sessiondetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import xyz.pavelkorolevxyz.podlodka.sessions.data.Session
import xyz.pavelkorolevxyz.podlodka.sessions.data.SessionRepository
import javax.inject.Inject

class SessionDetailsViewModel @Inject constructor(
    private val sessionRepository: SessionRepository,
) : ViewModel() {

    private val _sessionFlow: MutableStateFlow<Session?> = MutableStateFlow(null)
    val sessionFlow: Flow<Session?> get() = _sessionFlow

    fun onLoad(sessionId: String) {
        _sessionFlow.value = null
        loadSession(sessionId)
    }

    private fun loadSession(sessionId: String) {
        viewModelScope.launch {
            val session = sessionRepository.getSessionById(sessionId)
            _sessionFlow.emit(session)
        }
    }
}
