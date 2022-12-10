package com.vcarart.digimondex.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Attribute(
    @Expose @SerializedName("id") val id : Int,
    @Expose @SerializedName("attribute") val attribute : String
)