package com.example.mad_lab_exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_chapter.*

class ChapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter)

        _chapter_one.setOnClickListener{
            navigate()

        }
        _chapter_two.setOnClickListener{
            navigate()

        }
        _chapter_three.setOnClickListener{
            navigate()

        }
        _chapter_four.setOnClickListener{
            navigate()

        }
        _chapter_five.setOnClickListener{
            navigate()
        }
    }

    private fun navigate() {
        val intent = Intent(this, ReadBookActivity::class.java)
        startActivity(intent)
    }
}