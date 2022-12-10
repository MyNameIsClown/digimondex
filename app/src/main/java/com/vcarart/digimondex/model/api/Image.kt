package com.vcarart.digimondex.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Image(
    @Expose @SerializedName("href") val href : String,
    @Expose @SerializedName("transparent") val transparent : Boolean
)