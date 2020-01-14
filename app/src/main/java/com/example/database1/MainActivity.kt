package com.example.database1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import java.sql.Savepoint

class MainActivity : AppCompatActivity() {


    lateinit var editTextName: EditText   // object yaratıyorz
    lateinit var ratingBar: RatingBar
    lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName =
            findViewById(R.id.editTextName)  // burda yaratılan program içindeki object ile design daki birleştirilior
        ratingBar = findViewById(R.id.ratingBar)
        buttonSave = findViewById(R.id.buttonSave)

        buttonSave.setOnClickListener {


            saveHero()


        }
    }


    private fun saveHero() {
        val name = editTextName.text.toString().trim()

        if (name.isEmpty()) {
            editTextName.error = "please enter a name "
            return
        }
        val ref = FirebaseDatabase.getInstance().getReference("heroes")
        var heroId = ref.push().key
        heroId = heroId.toString()

        val hero = Hero(heroId, name, ratingBar.numStars)

        ref.child(heroId).setValue(hero).addOnCompleteListener {

            Toast.makeText(applicationContext, "hero saved succesfully", Toast.LENGTH_SHORT).show()
        }


    }
}

