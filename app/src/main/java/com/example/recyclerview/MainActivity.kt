package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.dragDrop.DragDropActivity
import com.example.recyclerview.multipleViewType.MultipleViewTypeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDragDrop.setOnClickListener {
            val intent = Intent(this, DragDropActivity::class.java)
            startActivity(intent)
        }

        btnMultiple.setOnClickListener {
            val intent = Intent(this, MultipleViewTypeActivity::class.java)
            startActivity(intent)
        }
    }
}
