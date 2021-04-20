package com.example.itrack.adapters;

public class NoteModel {
    public  String noteJournal;
    public String noteTime;

    public NoteModel(){

    }
    public NoteModel(String noteJournal, String noteTime) {
        this.noteJournal = noteJournal;
        this.noteTime = noteTime;
    }

    public String getNoteJournal() {
        return noteJournal;
    }
    public void setNoteJournal(String noteJournal) {
        this.noteJournal = noteJournal;
    }

    public String getNoteTime() {
        return noteTime;
    }

    public void setNoteTime(String noteTime) {
        this.noteTime = noteTime;
    }
}
