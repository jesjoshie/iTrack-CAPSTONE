package com.example.itrack

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.*


class MoodTracker : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood_tracker)
      /*  val actionbar = supportActionBar
        actionbar!!.setTitle("This is New Activity")
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)*/
     /*   val edit = findViewById<ImageButton>(R.id.add)
        edit.setOnClickListener {
            var dialog = CustomDialogFragment()
            dialog.show(supportFragmentManager,"customDialog")

        }*/

       /* val Smile = findViewById<ImageButton>(R.id.smile)
        val Good = findViewById<ImageButton>(R.id.good)
        val Meh = findViewById<ImageButton>(R.id.meh)
        val Sad = findViewById<ImageButton>(R.id.sad)
        val Awful = findViewById<ImageButton>(R.id.awful)*/
        val submit = findViewById<Button>(R.id.submitButton)
        submit.setOnClickListener {
            Toast.makeText(applicationContext,"Data saved",Toast.LENGTH_SHORT).show()
        }

      /*  Smile.setOnClickListener {
            val purposeIntent = Intent(applicationContext, SmileInterface::class.java)
            startActivity(purposeIntent)
        }
        Good.setOnClickListener {
            val purposeIntent = Intent(applicationContext, Goodinterface::class.java)
            startActivity(purposeIntent)
        }
        Meh.setOnClickListener {
            val purposeIntent = Intent(applicationContext, Mehinterface::class.java)
            startActivity(purposeIntent)
        }
        Sad.setOnClickListener {
            val purposeIntent = Intent(applicationContext, Sadinterface::class.java)
            startActivity(purposeIntent)
        }
        Awful.setOnClickListener {
            val purposeIntent = Intent(applicationContext, Awfulinterface::class.java)
            startActivity(purposeIntent)
        }
*/


    }



}

