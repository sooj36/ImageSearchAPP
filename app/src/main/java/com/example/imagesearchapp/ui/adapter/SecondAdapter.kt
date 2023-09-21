package com.example.imagesearchapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagesearchapp.R
import com.example.imagesearchapp.ui.model.KakaoImage

class SecondAdapter(var list: Context) :  RecyclerView.Adapter<SecondAdapter.viewHolder>() {

    // 북마크 리스트
    var bookmark = ArrayList<KakaoImage>()

    inner class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sitename: TextView = view.findViewById(R.id.item_sitename)
        val collection: TextView = view.findViewById(R.id.item_collection)
        val image_url: ImageView = view.findViewById(R.id.item_image_url)
        val datetime: TextView = view.findViewById(R.id.datetime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookmark.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.sitename.text = bookmark[position].sitename
        holder.collection.text = bookmark[position].collection
        holder.datetime.text = bookmark[position].datetime
        Log.d("sooj",bookmark[position].image_url)
        Glide.with(holder.image_url.context)
            .load(bookmark[position].image_url)
            .into(holder.image_url)
    }


}

