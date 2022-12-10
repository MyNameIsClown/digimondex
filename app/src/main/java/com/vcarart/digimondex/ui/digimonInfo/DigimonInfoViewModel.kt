package com.vcarart.digimondex.ui.digimonInfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vcarart.digimondex.model.api.Digimon
import com.vcarart.digimondex.service.DigimonApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DigimonInfoViewModel() : ViewModel() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://digimon-api.com/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: DigimonApiService = retrofit.create(DigimonApiService::class.java)

    val digimonInfo = MutableLiveData<Digimon>()

    fun getDigimonInfo(id: Int){
        val call = service.getDigimonInfo(id)

        call.enqueue(object : Callback<Digimon>{
            override fun onResponse(call: Call<Digimon>, response: Response<Digimon>) {
                response.body()?.let { digimon ->
                    digimonInfo.postValue(digimon)
                }
            }

            override fun onFailure(call: Call<Digimon>, t: Throwable) {
                call.cancel()
            }

        })
    }
}