package xyz.pavelkorolevxyz.podlodka.sessions.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionRepository @Inject constructor() {

    private val client = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    private val json = Json {
        ignoreUnknownKeys = true
    }

    @OptIn(ExperimentalSerializationApi::class)
    private val api = Retrofit.Builder()
        .client(client)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl("https://gist.githubusercontent.com/")
        .build()
        .create(PodlodkaApi::class.java)

    private var cachedSessions: List<Session>? = null

    suspend fun getSessions(): List<Session> {
        return cachedSessions ?: api.getSessions().also { cachedSessions = it }
    }

    suspend fun getSessionById(sessionId: String): Session {
        return getSessions().first { it.id == sessionId }
    }
}

interface PodlodkaApi {

    @GET("AJIEKCX/901e7ae9593e4afd136abe10ca7d510f/raw/61e7c1f037345370cf28b5ae6fdaffdd9e7e18d5/Sessions.json")
    suspend fun getSessions(): List<Session>
}
