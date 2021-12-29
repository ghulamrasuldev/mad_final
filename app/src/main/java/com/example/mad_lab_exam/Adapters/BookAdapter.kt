package com.example.mad_lab_exam.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mad_lab_exam.BookItem
import com.example.mad_lab_exam.R

class BookAdapter (private val book_list: List<BookItem>):
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val book_image: ImageView = itemView.findViewById(R.id._book_image)
        val book_name: TextView = itemView.findViewById(R.id._book_name)
        val book_code: TextView = itemView.findViewById(R.id._book_code)
        val book_date: TextView = itemView.findViewById(R.id._published_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context ).inflate(R.layout.activity_book_card,parent,false)
        return  BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentItem = book_list[position]
        holder.book_image.setImageResource(currentItem.imageResource)
        holder.book_name.text = currentItem.book_name
        holder.book_code.text = currentItem.book_code
        holder.book_date.text = currentItem.book_date
    }

    override fun getItemCount(): Int {
        return book_list.size
    }
}