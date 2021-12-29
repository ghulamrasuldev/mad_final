package com.example.mad_lab_exam

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mad_lab_exam.Adapters.BookAdapter
import java.io.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chatList = dummyData()
        val chatView = findViewById<RecyclerView>(R.id._available_books)
        chatView.adapter = BookAdapter(chatList)
        chatView.layoutManager =  LinearLayoutManager(this)
        chatView.addOnItemTouchListener(this)
    }




    private fun dummyData (): List<BookItem>{
        var text = "hello"
        try {
            val stream = assets.open("SampleData.txt");
            val reader = BufferedReader(InputStreamReader(stream))
            text = reader.readText()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val list = ArrayList<BookItem>()
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"History of Pakistan One", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"History of Pakistan Two", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"History of Pakistan Three", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"History of Pakistan Four", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"History of Pakistan Five", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"History of Pakistan Six", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"History of Pakistan Seven", "1122", "Date: 01/01/2021"))
        list.add(BookItem(R.drawable.ic_baseline_menu_book_24,"History of Pakistan Eight", "1122", "Date: 01/01/2021"))

        return list
    }

    private fun RecyclerView.addOnItemTouchListener(mainActivity: MainActivity) {
        val mIntent = Intent(context, ChapterActivity::class.java)
        startActivity(mIntent)
    }
}




