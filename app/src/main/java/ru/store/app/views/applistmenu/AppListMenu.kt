package ru.store.app.views.applistmenu

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.store.app.ui.theme.RuStoreAppTheme
import ru.store.app.common.Topic


@Composable
fun AppListScreen(onAppClick: (appId: String) -> Unit) {
    val items = remember { getStoreAppItems() }

    Column(modifier = Modifier.background(MaterialTheme.colorScheme.onBackground).fillMaxSize()) {
        Row(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .height(100.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.background,
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    "RuStore",
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.titleLarge,
                )
            }

            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.background,
            )
        }

        LazyColumn(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(vertical = 6.dp, horizontal = 10.dp)
        ) {
            items.forEachIndexed { index, item ->
                item(item.id) {
                    AppItemView(item, onAppClick)
                    if (index != items.size - 1) {
                        HorizontalDivider(
                            thickness = DividerDefaults.Thickness,
                            color = DividerDefaults.color
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun AppListScreenPreview() {
    RuStoreAppTheme {
        AppListScreen(onAppClick = {})
    }
}


fun getStoreAppItems(): List<AppItem> {
    return listOf(
        AppItem(
            id = "sberbank",
            name = "СберБанк Онлайн - с Салютом",
            shortDescription = "Больше чем банк",
            topic = Topic.Finance,
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        ),
        AppItem(
            id = "yabrowser",
            name = "Яндекс.Браузер - с Алисой",
            shortDescription = "Быстрый и безопасный браузер",
            topic = Topic.Instrument,
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        ),
        AppItem(
            id = "mailru",
            name = "Почта Mail.ru",
            shortDescription = "Почтовый клиент для любых ящиков",
            topic = Topic.Instrument,
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        ),
        AppItem(
            id = "yanavigator",
            name = "Яндекс Навигатор",
            shortDescription = "Парковки и заправки по пути",
            topic = Topic.Transport,
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        ),
        AppItem(
            id = "mymts",
            name = "Мой МТС",
            shortDescription = "Мой МТС - центр экосистемы МТС",
            topic = Topic.Instrument,
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        ),
        AppItem(
            id = "ya",
            name = "Яндекс - с Алисой",
            shortDescription = "Яндекс - поиск всегда под рукой",
            topic = Topic.Instrument,
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        ),
        AppItem(
            id = "ya_2",
            name = "Яндекс - с Алисой",
            shortDescription = "Яндекс - поиск всегда под рукой",
            topic = Topic.Instrument,
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        ),
        AppItem(
            id = "ya_3",
            name = "Яндекс - с Алисой",
            shortDescription = "Яндекс - поиск всегда под рукой",
            topic = Topic.Instrument,
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        ),
        AppItem(
            id = "ya_4",
            name = "Яндекс - с Алисой",
            shortDescription = "Яндекс - поиск всегда под рукой",
            topic = Topic.Instrument,
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        ),

        )


}

