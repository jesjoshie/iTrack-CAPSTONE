package com.example.itrack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import io.grpc.Server;

public class Mood extends AppCompatActivity {
    EditText etContent;
    Button button;
    CheckBox m1, m2, m3, m4, m5, m6, m7, m8;
    CheckBox cs1,cs2,cs3,cs4,cs5;
    FirebaseDatabase database;
    DatabaseReference reference;
    DatabaseReference fNotesDatabase;
    FirebaseAuth fAuth;
    Member member;
    Member1 member1;
    int i = 0;
    private Menu mainMenu;
    private  String noteID ="no";
    private boolean isExist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Mood");

        try {
            noteID = getIntent().getStringExtra("noteId");
            if (noteID.equals("no")) {
                mainMenu.getItem(0).setVisible(false);
                isExist = false;
            }else{
                isExist= true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        fAuth = FirebaseAuth.getInstance();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      fNotesDatabase = FirebaseDatabase.getInstance().getReference().child("Journal").child(fAuth.getCurrentUser().getUid());

        member = new Member();
        etContent = findViewById(R.id.journal);
        button = findViewById(R.id.submitButton);
        m1 = findViewById(R.id.family);
        m2 = findViewById(R.id.exercise);
        m3 = findViewById(R.id.date1);
        m4 = findViewById(R.id.sports);
        m5 = findViewById(R.id.friends);
        m6 = findViewById(R.id.sleep);
        m7 = findViewById(R.id.movie);
        m8 = findViewById(R.id.cleaning);

        cs1 = findViewById(R.id.smile);
        cs2 = findViewById(R.id.good);
        cs3 = findViewById(R.id.meh);
        cs4 = findViewById(R.id.sad);
        cs5 = findViewById(R.id.awful);

        String c1 = "Smile";
        String c2 = "Good";
        String c3 = "Meh";
        String c4 = "Sad";
        String c5 = "Awful";


        String d1 = "Family";
        String d2 = "Exercise";
        String d3 = "Date";
        String d4 = "Sports";
        String d5 = "Friends";
        String d6 = "Sleep";
        String d7 = "Movies";
        String d8 = "Cleaning";

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    i = (int) snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Journal = etContent.getText().toString().trim();
                if (!TextUtils.isEmpty(Journal)){
                    createNote(Journal);
                }else{
                    Snackbar.make(v,"Fill empty fields",Snackbar.LENGTH_SHORT).show();
                }
                if (m1.isChecked()) {
                    member.setMood1(d1);
                    reference.child(String.valueOf(i + 1)).setValue(member);
                } else {

                }
                if (m2.isChecked()) {
                    member.setMood2(d2);
                    reference.child(String.valueOf(i + 1)).setValue(member);

                } else {
                    if (m3.isChecked()) {
                        member.setMood3(d3);
                        reference.child(String.valueOf(i + 1)).setValue(member);

                    } else {
                        if (m4.isChecked()) {
                            member.setMood4(d4);
                            reference.child(String.valueOf(i + 1)).setValue(member);

                        } else {
                        }
                        if (m5.isChecked()) {
                            member.setMood5(d5);
                            reference.child(String.valueOf(i + 1)).setValue(member);

                        } else {

                        }
                        if (m6.isChecked()) {
                            member.setMood6(d6);
                            reference.child(String.valueOf(i + 1)).setValue(member);

                        } else {

                        }
                        if (m7.isChecked()) {
                            member.setMood7(d7);
                            reference.child(String.valueOf(i + 1)).setValue(member);

                        } else {

                        }
                        if (m8.isChecked()) {
                            member.setMood8 (d8);
                            reference.child(String.valueOf(i + 1)).setValue(member);
                        } else {
                        }
                        if (cs1.isChecked()){
                            member.setMod1(c1);
                            reference.child(String.valueOf(i + 1)).setValue(member);
                        }
                        else {

                        }
                        if (cs2.isChecked()){
                            member.setMod2(c2);
                            reference.child(String.valueOf(i + 1)).setValue(member);
                        }
                        else{

                        }
                        if (cs3.isChecked()){
                            member.setMod3(c3);
                            reference.child(String.valueOf(i + 1)).setValue(member);
                        }
                        else{

                        }
                        if (cs4.isChecked()){
                            member.setMod4(c4);
                            reference.child(String.valueOf(i + 1)).setValue(member);
                        }
                        else{

                        }
                        if (cs5.isChecked()){
                            member.setMod5(c5);
                            reference.child(String.valueOf(i + 1)).setValue(member);
                        }

                    }
                }
            }
        });
        putData();
    }
private void putData(){
        if (isExist){
        fNotesDatabase.child(noteID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild("journal")) {
                    String journal = snapshot.child("journal").getValue().toString();
                    etContent.setText(journal);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        }
}
    private void createNote(String journal) {
        if (fAuth.getCurrentUser() != null){
            if (isExist){
                Map updateMap = new HashMap();
                updateMap.put("journal", etContent.getText().toString().trim());
                updateMap.put("timestamp", ServerValue.TIMESTAMP);
            fNotesDatabase.child(noteID).updateChildren(updateMap);
            Toast.makeText(this,"Journal Updated",Toast.LENGTH_SHORT).show();
            }else{
            final DatabaseReference newNoteRef = fNotesDatabase.push();
            final  Map noteMap = new HashMap();
            noteMap.put("journal", journal);
            noteMap.put("timestamp", ServerValue.TIMESTAMP);

            Thread mainThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    newNoteRef.setValue(noteMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()){
                                Toast.makeText(Mood.this,"Journal added to the database" ,Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(Mood.this,"ERROR"+ task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            });
            mainThread.start();
            }
    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.new_note_menu,menu);
        mainMenu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
      super.onOptionsItemSelected(item);

      switch (item.getItemId()){
          case  android.R.id.home:
              finish();
              break;
          case R.id.new_note_delete_btn:
              if (!noteID.equals("no")){
                    deleteNote();
              }

              break;

      }

        return true;
    }
    private  void deleteNote(){
        fNotesDatabase.child(noteID).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    Toast.makeText(Mood.this,"NOTE DELETED",Toast.LENGTH_SHORT).show();
                    noteID = "no";
                    finish();
                }else{
                    Log.e("NewNoteActivity",task.getException().toString());
                    Toast.makeText(Mood.this,"ERROR"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}