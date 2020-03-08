package NoteOperations.Display;

import Note.Note;
import java.util.List;

public class NoteDisplaySimple implements NoteDisplay {

    @Override
    public void display(List<Note> notes) {
        notes.forEach(e -> System.out.println("Title: " + e.getTitle() + ". Author: " + e.getAuthor() + "."));
    }

}
