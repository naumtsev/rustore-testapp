package ru.store.app.views.applistmenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import ru.store.app.R
import ru.store.app.common.Topic
import ru.store.app.ui.theme.RuStoreAppTheme

@Composable
fun AppItemView(item: AppItem, onClick: (String) -> Unit) {
    Row(modifier = Modifier
        .padding(horizontal = 10.dp)
        .height(100.dp)
        .fillMaxWidth()
        .clickable(null, null,
            onClick = { onClick(item.id) }
        ),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        AsyncImage(
            model = item.iconUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(Modifier.width(16.dp))
        Column {
            Text(
                text = item.name,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleSmall,
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = item.shortDescription,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = getTopicName(item.topic),
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 12.sp,
            )
        }
    }
}


@Composable
fun getTopicName(topic: Topic): String {
    return when(topic) {
        Topic.Finance -> stringResource(R.string.topic_finance)
        Topic.Instrument -> stringResource(R.string.topic_instrument)
        Topic.Transport -> stringResource(R.string.topic_transport)
    }
}


@Preview
@Composable
fun AppItemPreview() {
    RuStoreAppTheme( ) {
        val item = remember { getStoreAppItems().first() }
        AppItemView(item) {
        }
    }
}