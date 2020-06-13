package com.example.uithreadforgfg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Assigning Layout elements
        val et = findViewById<EditText>(R.id.et1)
        val btn = findViewById<Button>(R.id.btnStart)
        val tv = findViewById<TextView>(R.id.tv1)

        //Button onClick action
        btn.setOnClickListener {

            // Converting Edit Text input to String
            val stringTime = (et.text).toString()

            // Converting stringTime to Integer
            val intTime = Integer.parseInt(stringTime)

            // Declaring Main Thread
            Thread(Runnable {

                // For loop Decrement
                for(i in intTime downTo 0){

                    //Updating Text View at current iteration
                    runOnUiThread{
                        tv.text = i.toString()
                    }

                    // Thread sleep for 1 sec
                    Thread.sleep(1000)
                }
            }).start()
        }
    }
}