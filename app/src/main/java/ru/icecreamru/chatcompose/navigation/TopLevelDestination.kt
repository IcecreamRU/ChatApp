package ru.icecreamru.chatcompose.navigation

import ru.icecreamru.fakechatcompose.R

enum class TopLevelDestination(
    val titleTextId: Int
) {
    AUTH(R.string.feature_auth),
    REGISTER(R.string.feature_register),
    CHAT(R.string.feature_chat),
    PROFILE(R.string.feature_profile),
}
