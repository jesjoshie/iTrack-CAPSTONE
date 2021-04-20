 package com.example.itrack


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import java.lang.String


class MoodTracker : AppCompatActivity() {
lateinit var database: FirebaseDatabase
lateinit var  reference: DatabaseReference
lateinit var  member: Member
   var i = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood_tracker)
       /* reference = database.reference*/
      /*  member = Member()

        val submit = findViewById<Button>(R.id.submitButton)
        val m1 = findViewById<CheckBox>(R.id.family)
        val m2 = findViewById<CheckBox>(R.id.exercise)
        val m3 = findViewById<CheckBox>(R.id.date1)
        val m4 = findViewById<CheckBox>(R.id.sports)
        val m5 = findViewById<CheckBox>(R.id.friends)
        val m6 = findViewById<CheckBox>(R.id.sleep)
        val m7 = findViewById<CheckBox>(R.id.movie)
        val m8 = findViewById<CheckBox>(R.id.cleaning)

        val d1 = "Family"
        val d2 = "Exercise"
        val d3 = "Date"
        val d4 = "Sports"
        val d5 = "Friends"
        val d6 = "Sleep"
        val d7 = "Movies"
        val d8 = "Cleaning"

    reference.addValueEventListener(object:ValueEventListener{
        override fun onDataChange(dataSnapshot: DataSnapshot) {
             if (dataSnapshot.exists()){
                   i = dataSnapshot.childrenCount as Int
             }

                }

        override fun onCancelled(databaseError: DatabaseError) {

        }

    } )

        submit.setOnClickListener {
            if (m1.isChecked){
                    member.mood(d1)
                    reference.child(String.valueOf(i + 1)).setValue(member)

            }else{

            }
            if(m2.isChecked){
                member.mood(d2)
                reference.child(String.valueOf(i + 1)).setValue(member)

            }else{
                if(m3.isChecked){
                    member.mood(d3)
                    reference.child(String.valueOf(i + 1)).setValue(member)

                }else{
                    if (m4.isChecked){
                        member.mood(d4)
                        reference.child(String.valueOf(i + 1)).setValue(member)

                    }else{

                    }
                    if(m5.isChecked){
                        member.mood(d5)
                        reference.child(String.valueOf(i + 1)).setValue(member)

                    }else{

                    }
                    if(m6.isChecked){
                        member.mood(d6)
                        reference.child(String.valueOf(i + 1)).setValue(member)

                    }else{

                    }
                    if(m7.isChecked){
                        member.mood(d7)
                        reference.child(String.valueOf(i + 1)).setValue(member)

                    }else{

                    }
                    if (m8.isChecked){
                        member.mood(d8)
                        reference.child(String.valueOf(i + 1)).setValue(member)

                    }
                }
            }


        }*/
    }
}

