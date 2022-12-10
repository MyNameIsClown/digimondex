package com.vcarart.digimondex.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DigimonApiResponse (
    @Expose @SerializedName("content") val content: List<DigimonResult>
)

data class DigimonResult (
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("href") val href: String
)