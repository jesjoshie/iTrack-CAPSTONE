package com.example.itrack.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itrack.R;


public class NoteViewHolder extends RecyclerView.ViewHolder {

    public View mView;
    public View noteCard;

    TextView textJournal,textTime;


    public NoteViewHolder(View itemView) {
        super(itemView);
        mView = itemView;

        textJournal = mView.findViewById(R.id.note_journal);
        textTime = mView.findViewById(R.id.note_time);
        noteCard = mView.findViewById(R.id.note_card);

    }
    public void  setNoteJournal(String journal){
        textJournal.setText(journal);
    }
    public void setNoteTime(String time){
        textTime.setText(time);
    }

}
