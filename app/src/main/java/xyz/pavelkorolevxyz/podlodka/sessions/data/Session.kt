package xyz.pavelkorolevxyz.podlodka.sessions.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Session(

    @SerialName("id")
    val id: String,

    @SerialName("speaker")
    val speaker: String,

    @SerialName("date")
    val date: String,

    @SerialName("timeInterval")
    val timeInterval: String,

    @SerialName("description")
    val description: String,

    @SerialName("imageUrl")
    val imageUrl: String,
)

val MockSession = Session(
    id = "1",
    speaker = "Степан Чурюканов",
    date = "19 апреля",
    timeInterval = "10:00-11:00",
    description = "Доклад: Краткий экскурс в мир многопоточности",
    imageUrl = "https://static.tildacdn.com/tild3432-3435-4561-b136-663134643162/photo_2021-04-16_18-.jpg"
)
