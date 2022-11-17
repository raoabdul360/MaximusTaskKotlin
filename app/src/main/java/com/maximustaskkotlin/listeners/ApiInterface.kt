package com.maximustaskkotlin.listeners

import com.maximustaskkotlin.models.FactModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("fact")
    fun getFact(): Call<FactModel>

}