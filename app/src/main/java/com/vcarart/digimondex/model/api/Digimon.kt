package com.vcarart.digimondex.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Digimon(
    @Expose @SerializedName("id") val id : String,
    @Expose @SerializedName("name") val name : String,
    @Expose @SerializedName("images") val images : List<Image>,
    @Expose @SerializedName("types") val types : List<Type>,
    @Expose @SerializedName("attributes") val attributes : List<Attribute>
)