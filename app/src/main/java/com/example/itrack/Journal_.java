package com.example.itrack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.itrack.adapters.NoteModel;
import com.example.itrack.adapters.NoteViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Journal_ extends AppCompatActivity {
private FirebaseAuth fAuth;
private RecyclerView mNotesList;
private GridLayoutManager gridLayoutManager;
private DatabaseReference fNotesDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_);
        mNotesList= findViewById(R.id.main_notes_list);
        gridLayoutManager = new GridLayoutManager(this,3,RecyclerView.VERTICAL,false);

        mNotesList.setHasFixedSize(true);
        mNotesList.setLayoutManager(gridLayoutManager);
        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser() != null){
            fNotesDatabase = FirebaseDatabase.getInstance().getReference().child("Journal").child(fAuth.getCurrentUser().getUid());
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<NoteModel, NoteViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<NoteModel, NoteViewHolder>(
                NoteModel.class,
                R.layout.single_note_layout,
                NoteViewHolder.class,
                fNotesDatabase


        ) {
            @Override
            protected void populateViewHolder(NoteViewHolder noteViewHolder, NoteModel noteModel, int i) {
                String noteId = getRef(i).getKey();
                fNotesDatabase.child(noteId).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChild("journal") && snapshot.hasChild("timestamp")) {
                            String journal = snapshot.child("journal").getValue().toString();
                            String timestamp = snapshot.child("timestamp").getValue().toString();

                            noteViewHolder.setNoteJournal(journal);
                            noteViewHolder.setNoteTime(timestamp);
                            noteViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent =  new Intent(Journal_.this,Mood.class);
                                    intent.putExtra("noteId",noteId);
                                    startActivity(intent);

                                }
                            });
                            noteViewHolder.noteCard.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Journal_.this, Mood.class);
                                    intent.putExtra("noteId", noteId);
                                    startActivity(intent);

                                }
                            });
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                    });


            }
        };
        mNotesList.setAdapter(firebaseRecyclerAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case  R.id.main_new_note_btn :
                Intent newIntent = new Intent(Journal_.this,Mood.class);
                startActivity(newIntent);
                break;
        }
        return true;
    }

private int dpToPx(int dp){
    Resources r = getResources();
    return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,r.getDisplayMetrics()));
    }
}