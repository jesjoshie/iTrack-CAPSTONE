package com.example.itrack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.concievebtn).setOnClickListener { concieve() }
    }
    //button click show dialog
    private fun concieve(){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.concieve_dialog,null);
        //alert dialogbuilder
        val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
        //show dialog
        mBuilder.show()
    }


    fun lastperiod(){

    }
    fun yearBirth(){

    }
    fun cycleLen(){

    }
}