package com.example.mybuttonapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        button.setOnClickListener{

            //codes

            Log.i("MainActivity" , "buton was clicked") //logcatte mesaj

            Toast.makeText(this , "butotn was clickted.." ,Toast.LENGTH_SHORT).show()


        }
    }
}
