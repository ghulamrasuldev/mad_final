package com.example.mad_lab_exam.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mad_lab_exam.BookItem
import com.example.mad_lab_exam.R
import com.example.mad_lab_exam.shopItem

class ShopAdaptor(private val item_list: List<shopItem>):
    RecyclerView.Adapter<ShopAdaptor.ShopViewHolder>() {
    class ShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item_name: TextView = itemView.findViewById(R.id.product_name_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return ShopViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val currentItem = item_list[position]
        holder.item_name.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return item_list.size
    }
}