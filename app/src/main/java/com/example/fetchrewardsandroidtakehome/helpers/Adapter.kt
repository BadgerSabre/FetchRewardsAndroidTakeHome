package com.example.fetchrewardsandroidtakehome.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardsandroidtakehome.models.ListItem
import com.example.fetchrewardsandroidtakehome.R

class ListAdapter(private val retrievedList: List<ListItem>) :RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return retrievedList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${retrievedList.size} ")


        return holder.bind(retrievedList[position])

    }
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {


        var id = itemView.findViewById<TextView>(R.id.tvId)
        var listId = itemView.findViewById<TextView>(R.id.tvListId)
        var name = itemView.findViewById<TextView>(R.id.tvListName)

        fun bind(listItem: ListItem) {
            if (listItem.name != null && listItem.name != "") {
                name.text = listItem.name
            }
            id.text = listItem.id.toString()
            listId.text = listItem.listId.toString()
        }

    }
}