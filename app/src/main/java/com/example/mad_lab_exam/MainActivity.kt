package com.example.mad_lab_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mad_lab_exam.Adapters.BookAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chatList = dummyData()
        val chatView = findViewById<RecyclerView>(R.id._available_books)
        chatView.adapter = BookAdapter(chatList)
        chatView.layoutManager =  LinearLayoutManager(this)
    }


    private fun dummyData (): List<BookItem>{
        val list = ArrayList<BookItem>()
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"Sell Like Crazy", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"Sell Like Crazy", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"Sell Like Crazy", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"Sell Like Crazy", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"Sell Like Crazy", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"Sell Like Crazy", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"Sell Like Crazy", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"Sell Like Crazy", "1122", "Date: 01/01/2021"))

        return list
    }
}