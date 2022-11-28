package com.example.fetchrewardsandroidtakehome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fetchrewardsandroidtakehome.helpers.ListAdapter
import com.example.fetchrewardsandroidtakehome.models.ListItem
import com.example.fetchrewardsandroidtakehome.services.ServiceBuilder
import com.example.fetchrewardsandroidtakehome.services.GetList
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadList()
    }
}

private fun loadList() {
    val destinationService = ServiceBuilder.buildService(GetList::class.java)
    val requestCall = destinationService.getFetchRewardsList()
    val recyclerview = R.id.recyclerview

    requestCall.enqueue(object : Callback<List<ListItem>>{
        override fun onResponse(call : Call<List<ListItem>>, response: Response<List<ListItem>>) {
            Log.d("Response", "onResponse: ${response.body()}")
            if (response.isSuccessful) {
                val retrievedList = response.body()!!
                val sortedList = retrievedList.sortedBy { it.listId }
                val finalSortedList = sortedList.sortedBy { it.name }
                Log.d("Response", "retrievedList size : ${retrievedList.size}")
                recyclerview.adapter = ListAdapter(finalSortedList)
            } else {
                Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
            }
        }
    })
}