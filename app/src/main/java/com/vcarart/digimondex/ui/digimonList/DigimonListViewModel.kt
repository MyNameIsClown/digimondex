package com.vcarart.digimondex.ui.digimonList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vcarart.digimondex.model.api.DigimonApiResponse
import com.vcarart.digimondex.model.api.DigimonResult
import com.vcarart.digimondex.service.DigimonApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DigimonListViewModel() : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://digimon-api.com/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: DigimonApiService = retrofit.create(DigimonApiService::class.java)

    val pokemonList = MutableLiveData<List<DigimonResult>>()

    fun getPokemonList(){
        val call = service.getDigimonList(100)

        call.enqueue(object : Callback<DigimonApiResponse>{
            override fun onResponse(call: Call<DigimonApiResponse>, response: Response<DigimonApiResponse>) {
                response.body()?.content?.let { list ->
                    pokemonList.postValue(list)
                }

            }

            override fun onFailure(call: Call<DigimonApiResponse>, t: Throwable) {
                call.cancel()
            }

        })
    }
}