package NotesOperations.Filter;

import Note.Note;
import NoteOperations.Filter.FilterOneOption;
import Store.SimpleStorage;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FilterOneOptionTest {

    @Before
    public void init() {
        Note note = new Note();
        note.setTitle("a");
        note.setAuthor("b");
        note.setContent("c");
        SimpleStorage simpleStorage = SimpleStorage.getInstance();
        simpleStorage.add(note);
    }

    @Test
    public void filterByTitleOption_trueValue_trueValue() {
        String input = "a" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FilterOneOption filterOneOption = new FilterOneOption();
        List<Note> list = filterOneOption.filterByTitleOption("title").orElse(null);

        assertThat("a", equalTo(list.get(0).getTitle()));
    }

    @Test
    public void filterByTitleOption_FalseValue_emptyList() {
        String input = "k" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FilterOneOption filterOneOption = new FilterOneOption();
        List<Note> list = filterOneOption.filterByTitleOption("title").orElse(null);

        assertTrue(list.isEmpty());
    }

    @Test
    public void filterByAuthorOption_trueValue_trueValue() {
        String input = "b" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FilterOneOption filterOneOption = new FilterOneOption();
        List<Note> list = filterOneOption.filterByAuthorOption("author").orElse(null);

        assertThat("b", equalTo(list.get(0).getAuthor()));
    }

    @Test
    public void filterByAuthorOption_FalseValue_emptyList() {
        String input = "k" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FilterOneOption filterOneOption = new FilterOneOption();
        List<Note> list = filterOneOption.filterByAuthorOption("author").orElse(null);

        assertTrue(list.isEmpty());
    }

    @Test
    public void filterByContentOption_trueValue_trueValue() {
        String input = "c" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FilterOneOption filterOneOption = new FilterOneOption();
        List<Note> list = filterOneOption.filterByContentOption("content").orElse(null);

        assertThat("c", equalTo(list.get(0).getContent()));
    }

    @Test
    public void filterByContentOption_FalseValue_emptyList() {
        String input = "k" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FilterOneOption filterOneOption = new FilterOneOption();
        List<Note> list = filterOneOption.filterByContentOption("content").orElse(null);

        assertTrue(list.isEmpty());
    }

    @Test
    public void filterByDateOption_trueValue_trueValue() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String dateTester = formatter.format(date);

        String input = dateTester + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FilterOneOption filterOneOption = new FilterOneOption();
        List<Note> list = filterOneOption.filterByDateOption("date").orElse(null);

        assertThat(formatter.format(date), equalTo(list.get(0).getCreationDate()));
    }

    @Test
    public void filterByDateOption_FalseValue_emptyList() {
        String input = "2000-05-05" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FilterOneOption filterOneOption = new FilterOneOption();
        List<Note> list = filterOneOption.filterByDateOption("date").orElse(null);

        assertTrue(list.isEmpty());
    }

}