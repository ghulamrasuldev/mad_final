package com.example.mad_lab_exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _book_one.setOnClickListener{
            navigate()
        }

        _book_two.setOnClickListener{
            navigate()
        }

        _book_three.setOnClickListener{
            navigate()
        }

        _book_four.setOnClickListener{
            navigate()
        }

        _book_five.setOnClickListener{
            navigate()
        }

        _book_six.setOnClickListener{
            navigate()
        }

        _book_seven.setOnClickListener{
            navigate()
        }

        _store.setOnClickListener{
            val intent = Intent(this, EcommercePage::class.java)
            startActivity(intent)
        }

        _firebase.setOnClickListener{
            val intent = Intent(this, Firebase::class.java)
            startActivity(intent)
        }

    }

    private fun navigate() {
        val intent = Intent(this, ChapterActivity::class.java)
        startActivity(intent)
    }

}




