package com.example.imagesearchapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagesearchapp.R
import com.example.imagesearchapp.ui.model.KakaoImage


class FirstAdapter : RecyclerView.Adapter<FirstAdapter.ViewHolder>() {

    var listener: OnBookmarkClickListener? = null
    interface OnBookmarkClickListener {
        fun onBookmarkClicked(kakaoImage: KakaoImage)
    }

    var list = ArrayList<KakaoImage>()

    // inner class 로 viewHolder 정리
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sitename: TextView = view.findViewById(R.id.item_sitename)
        val collection: TextView = view.findViewById(R.id.item_collection)
        val image_url: ImageView = view.findViewById(R.id.item_image_url)
        val datetime: TextView = view.findViewById(R.id.datetime)
        val heart : ImageView = view.findViewById(R.id.heart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.sitename.text = list[position].sitename
        holder.collection.text = list[position].collection
        holder.datetime.text = list[position].datetime
        Log.d("sooj", list[position].image_url)
        Glide.with(holder.image_url.context)
            .load(list[position].image_url)
            .into(holder.image_url)


        // 클릭리스너 설정
        holder.image_url.setOnClickListener {
            val item = list[position]
            listener?.onBookmarkClicked(kakaoImage = item)

            val isFavoriteList = mutableListOf<Int>()
            if (list[position].isFavorite) {
                holder.heart.isGone = true
                list[position].isFavorite = false
            } else {
                holder.heart.isVisible = true
                list[position].isFavorite = true
            }
        }


    }



}
