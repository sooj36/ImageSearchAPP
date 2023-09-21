package com.example.imagesearchapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentFirstBinding
import com.example.imagesearchapp.ui.model.KakaoImage
import org.w3c.dom.Text

class FirstAdapter : RecyclerView.Adapter<FirstAdapter.ViewHolder>() {

    var list = ArrayList<KakaoImage>()

    // inner class 로 viewHolder 정리
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var sitename : TextView

        init {
            sitename = view.findViewById(R.id.item_sitename)
        }

        var collection : TextView

        init {
            collection = view.findViewById(R.id.item_collection)
        }

        var image_url : ImageView

        init {
            image_url = view.findViewById(R.id.item_image_url)
        }

        var datatime : TextView

        init {
            datatime = view.findViewById(R.id.item_datatime)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.sitename.text = list[position].sitename
        holder.collection.text = list[position].collection
        holder.datatime.text = list[position].datatime
        Glide.with(holder.image_url.context)
            .load(list[position].image_url)
            .into(holder.image_url)

    }

    override fun getItemCount(): Int {
        return list.size
    }

}