package com.example.fetchrewardsandroidtakehome.services

import com.example.fetchrewardsandroidtakehome.models.ListItem
import retrofit2.Call
import retrofit2.http.GET

interface GetList {
    @GET("ListItems")
    fun getFetchRewardsList () : Call<List<ListItem>>
}