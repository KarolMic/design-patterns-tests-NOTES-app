package Store;

import Note.Note;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleStorageTest {

    private int previous;
    private SimpleStorage simpleStorage;
    private Note note;

    @Before
    public void init() {
        this.simpleStorage = SimpleStorage.getInstance();
        this.note = new Note();
        this.previous = simpleStorage.getNotes().size();
        note.setTitle("a");
        note.setAuthor("b");
        note.setContent("c");
        this.simpleStorage.add(note);
    }

    @Test
    public void add_addNoteToList_NoteAddedToList() {
        assertEquals(previous+1, simpleStorage.getNotes().size());
    }

    @Test
    public void remove_removeNoteFromList_NoteRemovedFromList() {
        List<Note> newListOfNotes = new ArrayList<>();
        newListOfNotes.add(note);

        simpleStorage.remove(newListOfNotes);
        assertEquals(previous, simpleStorage.getNotes().size());
    }

    @Test
    public void filterByTitle_filterByGivenTitle_NoteWithGivenTitle() {
        List<Note> temporaryList = simpleStorage.filterByTitle("a");

        assertEquals(simpleStorage.getNotes().get(0).getTitle(), temporaryList.get(0).getTitle());
    }

    @Test
    public void filterByTitle_filterByWrongTitle_EmptyList() {
        List<Note> temporaryList = simpleStorage.filterByTitle("k");

        assertEquals(true, temporaryList.isEmpty());
    }

    @Test
    public void filterByAuthor_filterByGivenAuthor_NoteWithGivenAuthor() {
        List<Note> temporaryList = simpleStorage.filterByAuthor("b");

        assertEquals(simpleStorage.getNotes().get(0).getAuthor(), temporaryList.get(0).getAuthor());
    }

    @Test
    public void filterByAuthor_filterByWrongAuthor_EmptyList() {
        List<Note> temporaryList = simpleStorage.filterByAuthor("k");

        assertEquals(true, temporaryList.isEmpty());
    }

    @Test
    public void filterByContent_filterByGivenContent_NoteWithGivenContent() {
        List<Note> temporaryList = simpleStorage.filterByContent("c");

        assertEquals(simpleStorage.getNotes().get(0).getContent(), temporaryList.get(0).getContent());
    }

    @Test
    public void filterByContent_filterByWrongContent_EmptyList() {
        List<Note> temporaryList = simpleStorage.filterByContent("k");

        assertTrue(temporaryList.isEmpty());
    }

    @Test
    public void filterByDate_filterByGivenDate_NoteWithGivenDate() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String dateTester = formatter.format(date);

        List<Note> temporaryList = simpleStorage.filterByDate(dateTester);

        assertEquals(simpleStorage.getNotes().get(0).getCreationDate(), temporaryList.get(0).getCreationDate());
    }

    @Test
    public void filterByDate_filterByWrongDate_EmptyList() {
        List<Note> temporaryList = simpleStorage.filterByDate("k");

        assertTrue(temporaryList.isEmpty());
    }

    @Test
    public void filterByTitleAuthor_filterByGivenTitleAuthor_NoteWithGivenTitleAuthor() {
        List<Note> temporaryList = simpleStorage.filterByTitleAuthor("a", "b");

        assertEquals(simpleStorage.getNotes().get(0).getContent(), temporaryList.get(0).getContent());
    }

    @Test
    public void filterByTitleAuthor_filterByWrongTitleAuthor_EmptyList() {
        List<Note> temporaryList = simpleStorage.filterByContent("k");

        assertTrue(temporaryList.isEmpty());
    }

    @Test
    public void filterByTitleContent_filterByGivenTitleContent_NoteWithGivenTitleContent() {
        List<Note> temporaryList = simpleStorage.filterByTitleContent("a", "c");

        assertEquals(simpleStorage.getNotes().get(0).getTitle(), temporaryList.get(0).getTitle());
        assertEquals(simpleStorage.getNotes().get(0).getContent(), temporaryList.get(0).getContent());
    }

    @Test
    public void filterByTitleContent_filterByWrongTitleContent_EmptyList() {
        List<Note> temporaryList = simpleStorage.filterByContent("k");

        assertTrue(temporaryList.isEmpty());
    }

    @Test
    public void filterByTitleDate_filterByGivenTitleDate_NoteWithGivenTitleDate() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String dateTester = formatter.format(date);

        List<Note> temporaryList = simpleStorage.filterByTitleDate("a", dateTester);

        assertEquals(simpleStorage.getNotes().get(0).getTitle(), temporaryList.get(0).getTitle());
        assertEquals(simpleStorage.getNotes().get(0).getCreationDate(),
                temporaryList.get(0).getCreationDate());
    }

    @Test
    public void filterByTitleDate_filterByWrongTitleDate_EmptyList() {
        List<Note> temporaryList = simpleStorage.filterByDate("k");

        assertTrue(temporaryList.isEmpty());
    }

    @Test
    public void filterByAuthorContent_filterByGivenAuthorContent_NoteWithGivenAuthorContent() {
        List<Note> temporaryList = simpleStorage.filterByAuthorContent("b", "c");

        assertEquals(simpleStorage.getNotes().get(0).getAuthor(), temporaryList.get(0).getAuthor());
        assertEquals(simpleStorage.getNotes().get(0).getContent(), temporaryList.get(0).getContent());
    }

    @Test
    public void filterByAuthorContent_filterByWrongAuthorContent_EmptyList() {
        List<Note> temporaryList = simpleStorage.filterByAuthorContent("k", "m");

        assertTrue(temporaryList.isEmpty());
    }

    @Test
    public void filterByAuthorDate_filterByGivenAuthorDate_NoteWithGivenAuthorDate() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String dateTester = formatter.format(date);

        List<Note> temporaryList = simpleStorage.filterByAuthorDate("b", dateTester);

        assertEquals(simpleStorage.getNotes().get(0).getAuthor(), temporaryList.get(0).getAuthor());
        assertEquals(simpleStorage.getNotes().get(0).getCreationDate(),
                temporaryList.get(0).getCreationDate());
    }

    @Test
    public void filterByAuthorDate_filterByWrongAuthorDate_EmptyList() {
        List<Note> temporaryList = simpleStorage.filterByAuthorDate("k", "m");

        assertTrue(temporaryList.isEmpty());
    }

    @Test
    public void filterByContentDate_filterByGivenContentDate_NoteWithGivenContentDate() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String dateTester = formatter.format(date);

        List<Note> temporaryList = simpleStorage.filterByContentDate("c", dateTester);

        assertEquals(simpleStorage.getNotes().get(0).getContent(), temporaryList.get(0).getContent());
        assertEquals(simpleStorage.getNotes().get(0).getCreationDate(),
                temporaryList.get(0).getCreationDate());
    }

    @Test
    public void filterByContentDate_filterByWrongContentDate_EmptyList() {
        List<Note> temporaryList = simpleStorage.filterByContentDate("k", "m");

        assertTrue(temporaryList.isEmpty());
    }

    @Test
    public void filterByTitleAuthorContent_filterByGivenTitleAuthorContent_NoteWithGivenTitleAuthorContent() {
        List<Note> temporaryList = simpleStorage.filterByTitleAuthorContent("a", "b", "c");

        assertEquals(simpleStorage.getNotes().get(0).getTitle(), temporaryList.get(0).getTitle());
        assertEquals(simpleStorage.getNotes().get(0).getAuthor(), temporaryList.get(0).getAuthor());
        assertEquals(simpleStorage.getNotes().get(0).getContent(), temporaryList.get(0).getContent());
    }

    @Test
    public void filterByTitleAuthorContent_filterByWrongTitleAuthorContent_EmptyList() {
        List<Note> temporaryList = simpleStorage.filterByTitleAuthorContent("l", "k", "m");

        assertTrue(temporaryList.isEmpty());
    }

    @Test
    public void filterByTitleAuthorContentDate_filterByGivenFields_NoteWithGivenFields() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String dateTester = formatter.format(date);

        List<Note> temporaryList =
                simpleStorage.filterByTitleAuthorContentDate("a", "b", "c", dateTester);

        assertEquals(simpleStorage.getNotes().get(0).getTitle(), temporaryList.get(0).getTitle());
        assertEquals(simpleStorage.getNotes().get(0).getAuthor(), temporaryList.get(0).getAuthor());
        assertEquals(simpleStorage.getNotes().get(0).getContent(), temporaryList.get(0).getContent());
        assertEquals(simpleStorage.getNotes().get(0).getCreationDate(), temporaryList.get(0).getCreationDate());
    }

    @Test
    public void filterByTitleAuthorContentDate_filterByWrongFields_EmptyList() {
        List<Note> temporaryList =
                simpleStorage.filterByTitleAuthorContentDate("l", "k", "m", "z");

        assertTrue(temporaryList.isEmpty());
    }

}