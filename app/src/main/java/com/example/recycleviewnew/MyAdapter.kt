package com.example.recycleviewnew

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycleviewnew.retrofitData.MyDataItem
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(val context: Context, val userArrayList : List<MyDataItem>) : RecyclerView.Adapter<MyAdapter.MyHoldar>() {
    class MyHoldar(itemView : View) : RecyclerView.ViewHolder(itemView){
        var name : TextView
        var image : CircleImageView
        init {
            name = itemView.findViewById(R.id.txt)
            image = itemView.findViewById(R.id.profile_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHoldar {
        val itemView = LayoutInflater.from(context).inflate(R.layout.samplelayout,parent,false)
        return MyHoldar(itemView)
    }

    override fun getItemCount(): Int {
        return userArrayList.size
    }

    override fun onBindViewHolder(holder: MyHoldar, position: Int) {
        val currentItem = userArrayList[position]
        holder.name.text = currentItem.login
        Glide.with(context)
            .load(currentItem.avatar_url)
            .into(holder.image);
    }

}