package xyz.pavelkorolevxyz.podlodka.sessions.data

import android.app.Application
import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject

class FavoriteRepository @Inject constructor(
    application: Application,
) {

    private val prefs = application.getSharedPreferences(TITLE, Context.MODE_PRIVATE)

    fun getFavoriteSet(): Set<String> = prefs.all.keys

    private fun canFavorite(): Boolean =
        prefs.all.size < MAX_FAVORITES_COUNT

    fun setFavorite(
        sessionId: String,
        isFavorite: Boolean,
    ): Boolean {
        if (isFavorite && !canFavorite()) return false
        prefs.edit {
            if (isFavorite) {
                putBoolean(sessionId, isFavorite)
            } else {
                remove(sessionId)
            }
        }
        return true
    }

    private companion object {

        const val TITLE = "favorites"
        const val MAX_FAVORITES_COUNT = 3
    }
}
