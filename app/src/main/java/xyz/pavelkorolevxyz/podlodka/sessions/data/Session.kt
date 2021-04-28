package xyz.pavelkorolevxyz.podlodka.sessions.data

data class Session(
    val id: String,
    val speaker: String,
    val date: String,
    val timeInterval: String,
    val description: String,
    val imageUrl: String,
)

val MockSessions = listOf(
    Session(
        id = "1",
        speaker = "Степан Чурюканов",
        date = "19 апреля",
        timeInterval = "10:00-11:00",
        description = "Доклад: Краткий экскурс в мир многопоточности",
        imageUrl = "https://static.tildacdn.com/tild3432-3435-4561-b136-663134643162/photo_2021-04-16_18-.jpg"
    ),
    Session(
        id = "2",
        speaker = "Дмитрий Мельников",
        date = "19 апреля",
        timeInterval = "19:00-20:00",
        description = "Доклад: Основы Reactive Programming с использованием RxJava",
        imageUrl = "error"
    ),
    Session(
        id = "3",
        speaker = "Сергей Боиштян",
        date = "20 апреля",
        timeInterval = "10:00-11:00",
        description = "Собеседование по многопоточности",
        imageUrl = "https://static.tildacdn.com/tild6532-3838-4337-a664-343564346562/2020-06-11_115257.jpg"
    ),
    Session(
        id = "4",
        speaker = "Алексей Быков",
        date = "20 апреля",
        timeInterval = "19:00-20:00",
        description = "Доклад: Организуем кеширование строчки",
        imageUrl = "https://static.tildacdn.com/tild6466-3831-4266-b962-306336663963/photo_2020-06-16_011.jpeg"
    ),
    Session(
        id = "5",
        speaker = "Алексей Панов",
        date = "21 апреля",
        timeInterval = "10:00-11:00",
        description = "Доклад: Всё, что нужно знать о корутинах",
        imageUrl = "https://static.tildacdn.com/tild6364-6664-4235-b731-333261663338/photo_2021-04-16_18-.jpg"
    ),
    Session(
        id = "6",
        speaker = "Артур Бадретдинов, Павел Щегельский",
        date = "21 апреля",
        timeInterval = "19:00-20:00",
        description = "Круглый стол: Планируем переход с Rx на Coroutines и " +
            "пытаемся объяснить бизнесу почему это надо делать уже сейчас",
        imageUrl = "https://static.tildacdn.com/tild3431-6431-4338-b332-313139613636/Aussie_Ava.jpeg"
    ),
    Session(
        id = "7",
        speaker = "Ильмир Усманов",
        date = "22 апреля",
        timeInterval = "10:00-11:00",
        description = "Доклад: Suspend, Intercept, Resume - три шага асинхронщины",
        imageUrl = "https://static.tildacdn.com/tild3834-3134-4366-a638-363130393361/102030_640647767_Ilm.jpeg"
    ),
    Session(
        id = "8",
        speaker = "Артем Осипов, Кирилл Розов",
        date = "22 апреля",
        timeInterval = "19:00-20:00",
        description = "Интерактивная сессия: Puzzlers",
        imageUrl = "https://static.tildacdn.com/tild3039-6536-4737-b038-623438333139/photo_2020-09-30_205.jpeg"
    ),
    Session(
        id = "9",
        speaker = "Михаил Горюнов",
        date = "23 апреля",
        timeInterval = "10:00-11:00",
        description = "«Чистые потоки» - почему мы не переходим на RxJava или Coroutines",
        imageUrl = "https://static.tildacdn.com/tild3766-3030-4166-b432-316139386239/noroot.png"
    ),
    Session(
        id = "10",
        speaker = "Михаил Левченко, Сергей Боиштян, Владислав Шипугин",
        date = "23 апреля",
        timeInterval = "19:00-20:00",
        description = "«Прожарка» технологий: выясняем что лучше в жарких спорах",
        imageUrl = "https://static.tildacdn.com/tild3963-3434-4032-b762-323532333133/noroot.png"
    ),
    Session(
        id = "11",
        speaker = "Антон Шилов",
        date = "26 апреля",
        timeInterval = "10:00-11:00",
        description = "Compose: BETA",
        imageUrl = "https://static.tildacdn.com/tild3965-3065-4632-a334-633930323161/photo_2021-04-21_15-.jpg"
    ),
    Session(
        id = "12",
        speaker = "Денис Неклюдов",
        date = "26 апреля",
        timeInterval = "18:00-19:30",
        description = "Доклад: Камасутра с CameraX. Распознавание поз",
        imageUrl = "https://static.tildacdn.com/tild3361-3637-4564-b939-346566383538/2020-06-11_115040.jpg"
    ),
    Session(
        id = "13",
        speaker = "Владислав Шипугин",
        date = "27 апреля",
        timeInterval = "10:00-11:00",
        description = "LiveCoding: Добавляем в проект Jetpack Navigation",
        imageUrl = "https://static.tildacdn.com/tild6438-3038-4639-a336-666561613031/new-avatar.jpg"
    ),
    Session(
        id = "14",
        speaker = "Андрей Куликов",
        date = "27 апреля",
        timeInterval = "19:00-20:00",
        description = "Доклад: Compose. Advanced",
        imageUrl = "https://static.tildacdn.com/tild3136-6564-4130-a464-303735633233/__Google.JPG"
    ),
    Session(
        id = "15",
        speaker = "Алексей Гладков",
        date = "28 апреля",
        timeInterval = "10:00-11:00",
        description = "Доклад: Compose. Работа со стейтами",
        imageUrl = "https://static.tildacdn.com/tild6361-6637-4634-b265-613832653832/photo_2021-04-21_15-.jpg"
    ),
    Session(
        id = "16",
        speaker = "Дмитрий Мовчан",
        date = "28 апреля",
        timeInterval = "19:00-20:00",
        description = "Доклад: Paging 3",
        imageUrl = "https://static.tildacdn.com/tild3439-3763-4335-b530-363563356539/2020-06-11_115210.jpg"
    ),
    Session(
        id = "17",
        speaker = "Андрей Берюхов",
        date = "29 апреля",
        timeInterval = "10:00-11:00",
        description = "Доклад: WorkManager",
        imageUrl = "https://static.tildacdn.com/tild3933-6165-4534-b137-613766633166/__.jpg"
    ),
    Session(
        id = "18",
        speaker = "Николай Иготти",
        date = "29 апреля",
        timeInterval = "18:00-19:00",
        description = "Интервью: Compose Архитектура",
        imageUrl = "https://static.tildacdn.com/tild3433-3138-4165-b135-653934323134/IMG_0653.JPG"
    ),
)
