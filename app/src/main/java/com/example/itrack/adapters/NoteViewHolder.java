package com.example.itrack.adapters;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itrack.R;


public class NoteViewHolder extends RecyclerView.ViewHolder {

    View mView;
    TextView textJournal,textTime;

    public NoteViewHolder(View itemView) {
        super(itemView);
        mView = itemView;

        textJournal = mView.findViewById(R.id.note_journal);
        textTime = mView.findViewById(R.id.note_time);


    }
    public void  setNoteJournal(String journal){
        textJournal.setText(journal);
    }
    public void setNoteTime(String time){
        textTime.setText(time);
    }

}
