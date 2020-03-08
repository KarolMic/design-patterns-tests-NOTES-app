package NotesOperations.Add;
import Note.Note;
import Note.NoteProvider;
import Store.SimpleStorage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddNoteTest {

    @Test
    public void addNote_withStringFields_addedWithStringFields() {
        NoteProvider noteProvider = new NoteProvider();
        Note note = noteProvider.getNewNote("one", "two", "three");
        SimpleStorage simpleStorage = new SimpleStorage();
        simpleStorage.add(note);

        assertEquals(simpleStorage.getNotes().get(0).getTitle(), "one");
        assertEquals(simpleStorage.getNotes().get(0).getAuthor(), "two");
        assertEquals(simpleStorage.getNotes().get(0).getContent(), "three");
    }

    @Test
    public void addNote_withNullFields_addedWithStringFields() {
        NoteProvider noteProvider = new NoteProvider();
        Note note = noteProvider.getNewNote(null, null, null);
        SimpleStorage simpleStorage = new SimpleStorage();
        simpleStorage.add(note);

        assertEquals(simpleStorage.getNotes().get(0).getTitle(), null);
        assertEquals(simpleStorage.getNotes().get(0).getAuthor(), null);
        assertEquals(simpleStorage.getNotes().get(0).getContent(), null);
    }

}