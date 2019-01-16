package com.novoda.workshop.contributors.data

import com.squareup.moshi.Json

internal data class Contributor(
    @field:Json(name = "login") val name: String,
    val contributions: Int,
    @field:Json(name = "avatar_url") val avatarUrl: String
)
