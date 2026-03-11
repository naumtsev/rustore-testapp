package ru.store.app.views.applist

import ru.store.app.common.Topic

data class AppItem(
    val id: String,
    val name: String,
    val shortDescription: String,
    val topic: Topic,
    val iconUrl: String
)
