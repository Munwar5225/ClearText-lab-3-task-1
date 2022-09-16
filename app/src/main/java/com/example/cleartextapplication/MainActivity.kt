package com.example.cleartextapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textTyped : EditText = findViewById(R.id.textTyped)
        val clear : Button = findViewById(R.id.clear)
        val undo  : Button  =  findViewById(R.id.undo)
        var text = ""
        clear.setOnClickListener {
            if(textTyped.text.toString().isEmpty()){
                Toast.makeText(this, "Not text Available", Toast.LENGTH_LONG).show()

            }
            else{
                text=textTyped.text.toString()
                textTyped.text = null
            }
        }
        undo.setOnClickListener {
            if(text.isNotEmpty()){
                textTyped.setText("$text ${textTyped.text}", TextView.BufferType.EDITABLE)
                text = ""
            }
        }
    }
}