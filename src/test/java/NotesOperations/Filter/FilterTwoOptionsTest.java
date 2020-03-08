package NotesOperations.Filter;

import Note.Note;
import NoteOperations.Filter.FilterTwoOptions;
import Store.SimpleStorage;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@Ignore
public class FilterTwoOptionsTest {

    private FilterTwoOptions filterTwoOptions;

    @Before
    public void init() {
        this.filterTwoOptions = new FilterTwoOptions();
        Note note = new Note();
        note.setTitle("a");
        note.setAuthor("b");
        note.setContent("c");
        SimpleStorage simpleStorage = SimpleStorage.getInstance();
        simpleStorage.add(note);
    }

    @Test
    public void filterByTitleAuthorOption_trueValue_trueValue() {
        String input = "a" + System.lineSeparator() + "b" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputStream savedStandardInputStream = System.in;
        System.setIn(in);

        List<Note> list = filterTwoOptions.filterByTitleAuthorOption("title, author")
                .orElse(null);

        System.setIn(savedStandardInputStream);

        assertThat("a", equalTo(list.get(0).getTitle()));
        assertThat("b", equalTo(list.get(0).getAuthor()));
    }

    @Test
    public void filterByTitleAuthorOption_falseValue_falseValue() {
        String input = "n" + System.lineSeparator() + "m" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputStream savedStandardInputStream = System.in;
        System.setIn(in);

        List<Note> list = filterTwoOptions.filterByTitleAuthorOption("title, author")
                .orElse(null);

        System.setIn(savedStandardInputStream);

        assertTrue(list.isEmpty());
    }

    @Test
    public void filterByTitleContentOption_trueValue_trueValue() {
        String input = "a" + System.lineSeparator() + "c" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputStream savedStandardInputStream = System.in;
        System.setIn(in);

        List<Note> list = filterTwoOptions.filterByTitleContentOption("title, content")
                .orElse(null);

        System.setIn(savedStandardInputStream);

        assertThat("a", equalTo(list.get(0).getTitle()));
        assertThat("c", equalTo(list.get(0).getContent()));
    }

    @Test
    public void filterByTitleContentOption_falseValue_falseValue() {
        String input = "n" + System.lineSeparator() + "m" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputStream savedStandardInputStream = System.in;
        System.setIn(in);

        List<Note> list = filterTwoOptions.filterByTitleContentOption("title, content")
                .orElse(null);

        System.setIn(savedStandardInputStream);

        assertTrue(list.isEmpty());
    }

    @Test
    public void filterByAuthorContentOption_trueValue_trueValue() {
        String input = "b" + System.lineSeparator() + "c" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputStream savedStandardInputStream = System.in;
        System.setIn(in);

        List<Note> list = filterTwoOptions.filterByAuthorContentOption("author, content")
                .orElse(null);

        System.setIn(savedStandardInputStream);

        assertThat("b", equalTo(list.get(0).getAuthor()));
        assertThat("c", equalTo(list.get(0).getContent()));
    }

    @Test
    public void filterByAuthorContentOption_falseValue_falseValue() {
        String input = "n" + System.lineSeparator() + "m" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputStream savedStandardInputStream = System.in;
        System.setIn(in);

        List<Note> list = filterTwoOptions.filterByAuthorContentOption("author, content")
                .orElse(null);

        System.setIn(savedStandardInputStream);

        assertTrue(list.isEmpty());
    }

}