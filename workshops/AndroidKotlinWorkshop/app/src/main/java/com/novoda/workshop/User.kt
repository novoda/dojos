package com.novoda.workshop

import com.squareup.moshi.Json

internal data class User(
    val login: String,
    val contributions: Int,
    @field:Json(name = "avatar_url") val avatarUrl: String?
)
