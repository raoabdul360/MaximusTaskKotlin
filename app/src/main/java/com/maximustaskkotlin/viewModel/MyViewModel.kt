package com.maximustaskkotlin.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maximustaskkotlin.listeners.ApiInterface
import com.maximustaskkotlin.models.FactModel
import com.maximustaskkotlin.network.RetrofitClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel : ViewModel() {

    val factModel = MutableLiveData<FactModel>()

    fun loadFact()                                                      // Function to get fact
    {

        val apiInterface = RetrofitClass.getInstance().create(ApiInterface::class.java)

        val call: Call<FactModel> = apiInterface.getFact()
        call.enqueue(object : Callback<FactModel> {
            override fun onFailure(call: Call<FactModel>, t: Throwable) {
                Log.e("retrofit", "call failed")
            }

            override fun onResponse(call: Call<FactModel>, response: Response<FactModel>) {

                factModel.postValue(response.body())
            }

        })
    }

}