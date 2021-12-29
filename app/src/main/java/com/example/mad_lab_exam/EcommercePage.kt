package com.example.mad_lab_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mad_lab_exam.Adapters.ShopAdaptor

class EcommercePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecommerce_page)
        val itemList = dummyData()
        val itemView = findViewById<RecyclerView>(R.id.products_recycler_view)
        itemView.adapter = ShopAdaptor(itemList)
        itemView.layoutManager =  LinearLayoutManager(this)
    }

    private fun dummyData (): List<shopItem>{
        val list = ArrayList<shopItem>()
        list.add(shopItem("Item One"))
        list.add(shopItem("Item Two"))
        list.add(shopItem("Item Three"))
        list.add(shopItem("Item Four"))
        list.add(shopItem("Item Five"))
        list.add(shopItem("Item Six"))
        list.add(shopItem("Item Seven"))
        list.add(shopItem("Item Eight"))
        list.add(shopItem("Item Nine"))
        list.add(shopItem("Item Ten"))
        return list
    }
}