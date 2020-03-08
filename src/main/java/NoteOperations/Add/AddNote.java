package NoteOperations.Add;

import Note.Note;
import Note.NoteProvider;
import NoteOperations.TypeFields;
import Store.SimpleStorage;

import java.util.Scanner;

public class AddNote {

    private NoteProvider noteProvider = new NoteProvider();;
    private Scanner scanner = new Scanner(System.in);
    SimpleStorage simpleStorage = SimpleStorage.getInstance();
    TypeFields typeFields = new TypeFields();

    public void addNote() {
        Note note = noteProvider.getNewNote(typeFields.setTitle(),
                typeFields.setAuthor(), typeFields.setContent());
        simpleStorage.add(note);
    }

}
