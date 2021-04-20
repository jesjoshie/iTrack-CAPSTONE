package com.example.itrack

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.itrack.models.last_period_info
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var  mNotesList: RecyclerView
    lateinit var  gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*        mNotesList = findViewById(R.id.main_notes_list)
        gridLayoutManager = GridLayoutManager(this,3,VERTICAL,false)

        mNotesList.setHasFixedSize(true)
        mNotesList.layoutManager(gridLayoutManager)*/

    }
}