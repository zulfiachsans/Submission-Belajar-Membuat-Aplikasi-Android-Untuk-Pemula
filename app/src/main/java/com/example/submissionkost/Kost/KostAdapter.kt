package com.example.submissionkost.Kost

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submissionkost.R

class KostAdapter (val listKost : ArrayList<Kost>) : RecyclerView.Adapter<KostAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.layout_kost, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listKost.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, rate, photo, overview, detail) = listKost[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvRate.text = rate

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, KostDetail::class.java)
            moveDetail.putExtra(KostDetail.EXTRA_RATE, rate)
            moveDetail.putExtra(KostDetail.EXTRA_NAME, name)
            moveDetail.putExtra(KostDetail.EXTRA_PHOTO, photo)
            moveDetail.putExtra(KostDetail.EXTRA_DETAIL, detail)
            moveDetail.putExtra(KostDetail.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvRate: TextView = itemView.findViewById(R.id.tv_item_rate)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}