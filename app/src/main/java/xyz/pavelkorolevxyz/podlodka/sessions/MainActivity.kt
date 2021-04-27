package xyz.pavelkorolevxyz.podlodka.sessions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.transform.CircleCropTransformation
import com.google.accompanist.coil.rememberCoilPainter
import xyz.pavelkorolevxyz.podlodka.sessions.data.MockSessions
import xyz.pavelkorolevxyz.podlodka.sessions.data.Session
import xyz.pavelkorolevxyz.podlodka.sessions.ui.theme.PodlodkaTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PodlodkaApp {
                //SessionsList(sessions = MockSessions)
                SessionDetails(session = MockSessions.first())
            }
        }
    }
}

@Composable
fun PodlodkaApp(content: @Composable () -> Unit) {
    PodlodkaTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Preview(name = "Session List", showBackground = true)
@Composable
fun SessionListPreview() {
    SessionsList(sessions = MockSessions)
}

@Preview(name = "Session Details", showBackground = true)
@Composable
fun SessionDetailsPreview() {
    SessionDetails(session = MockSessions.first())
}

@Composable
fun SessionsList(sessions: List<Session>) {
    val text = remember { mutableStateOf("") }
    val filteredSessions = sessions.filter { session ->
        val query = text.value
        query.isBlank() ||
                session.speaker.contains(query, ignoreCase = true) ||
                session.description.contains(query, ignoreCase = true)
    }
    LazyColumn {
        item {
            OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = text.value,
                onValueChange = {
                    text.value = it
                },
                label = {
                    Text(stringResource(id = R.string.search))
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                },
            )
        }
        if (filteredSessions.isEmpty()) {
            item {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(id = R.string.session_not_found),
                )
            }
            return@LazyColumn
        }
        if (filteredSessions.isNotEmpty()) {
            item {
                Text(
                    modifier = Modifier.padding(16.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    text = stringResource(id = R.string.favorite),
                )
            }
            item {
                LazyRow {
                    for (session in filteredSessions) {
                        item {
                            Card(
                                shape = RoundedCornerShape(16.dp),
                                elevation = 4.dp,
                                modifier = Modifier
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                                    .size(156.dp)
                                    .clickable {
                                        // TODO on session card click
                                    },
                            ) {
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Text(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        text = session.timeInterval,
                                    )
                                    Text(
                                        modifier = Modifier.weight(1f),
                                        fontSize = 14.sp,
                                        text = session.date,
                                    )
                                    Text(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        text = session.speaker,
                                    )
                                    Text(
                                        fontSize = 16.sp,
                                        text = session.description,
                                        maxLines = 3,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        item {
            Text(
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.sessions),
            )
        }
        var prevSessionDate: String? = null
        for (session in filteredSessions) {
            if (prevSessionDate != session.date) {
                item {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = session.date,
                    )
                }
                prevSessionDate = session.date
            }
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = 4.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clickable {
                            // TODO on session card click
                        },
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        val imagePainter = rememberCoilPainter(
                            request = session.imageUrl,
                            requestBuilder = {
                                placeholder(R.drawable.ic_launcher_foreground)
                                transformations(CircleCropTransformation())
                            },
                        )
                        Image(
                            modifier = Modifier.size(56.dp),
                            painter = imagePainter,
                            contentDescription = session.speaker,
                        )
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp),
                        ) {
                            Text(
                                fontWeight = FontWeight.Bold,
                                text = session.speaker,
                            )
                            Text(
                                fontWeight = FontWeight.Bold,
                                text = session.timeInterval,
                            )
                            Text(
                                text = session.description,
                            )
                        }
                        val isLiked = remember { mutableStateOf(false) }
                        IconButton(
                            onClick = {
                                isLiked.value = !isLiked.value
                            }
                        ) {
                            when (isLiked.value) {
                                true -> Icon(
                                    painter = painterResource(id = R.drawable.ic_heart),
                                    contentDescription = stringResource(id = R.string.favorite_remove),
                                    tint = Color.Red,
                                )
                                false -> Icon(
                                    painter = painterResource(id = R.drawable.ic_heart_outline),
                                    contentDescription = stringResource(id = R.string.favorite_add),
                                    tint = Color.Gray,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SessionDetails(session: Session) {
    val imagePainter = rememberCoilPainter(
        request = session.imageUrl,
        requestBuilder = {
            placeholder(R.drawable.ic_launcher_foreground)
            transformations(CircleCropTransformation())
        },
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier.size(300.dp),
                painter = imagePainter,
                contentDescription = session.speaker,
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                text = session.speaker,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar_blank),
                    contentDescription = null,
                )
                Text(text = "${session.date}, ${session.timeInterval}")
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                fontSize = 18.sp,
                text = session.description,
            )
        }
    }
}