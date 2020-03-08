package NoteOperations.Display;

import Note.Note;

import java.util.List;

public class NoteDisplayFull implements NoteDisplay {

    @Override
    public void display(List<Note> notes) {
        notes.forEach(e -> System.out.println("Title: " + e.getTitle() + ". Author: " + e.getAuthor()
                + ". Content: " + e.getContent() + ". Creation date: " + e.getCreationDate() + "."));
    }

}
