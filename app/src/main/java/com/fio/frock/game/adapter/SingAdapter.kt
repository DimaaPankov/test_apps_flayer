package com.fio.frock.game.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fio.frock.game.R
import com.fio.frock.game.fragment.ModelMusic

var music = ""

var qrData = ""

class SingAdapter(var dataList:ArrayList<ModelMusic>, var onClick:() -> Unit) : RecyclerView.Adapter<SingAdapter.MyViewHolder>() {

    inner  class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val TVtitle: TextView = itemView.findViewById(R.id.TVtitle)
        val TVsinger: TextView = itemView.findViewById(R.id.TVsinger)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        view.setOnClickListener{
            onClick()
        }
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Log.d("IIII",dataList.toString())
        holder.TVtitle.text = "-"+dataList[position].music
        music = dataList[position].music
        holder.TVsinger.text = dataList[position].artist

        qrData = "ID:\n${arrayListOf("1221","9340","0435","1234","5849","9032","0985","1083").random()}\n\n" +
                "Music:\n $music"
    }



    override fun getItemCount(): Int {
        return dataList.size
    }
}

