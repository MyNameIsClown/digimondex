package com.vcarart.digimondex.service

import com.vcarart.digimondex.model.api.DigimonApiResponse
import com.vcarart.digimondex.model.api.Digimon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DigimonApiService {
    @GET("digimon/{id}")
    fun getDigimonInfo(@Path("id") id: Int): Call<Digimon>
    @GET("digimon")
    fun getDigimonList(@Query("pageSize") pageSize: Int): Call<DigimonApiResponse>
}