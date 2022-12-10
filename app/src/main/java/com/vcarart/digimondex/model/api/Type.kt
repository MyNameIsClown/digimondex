package com.vcarart.digimondex.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Type(
    @Expose @SerializedName("id") val id : Int,
    @Expose @SerializedName("type") val type : String
)