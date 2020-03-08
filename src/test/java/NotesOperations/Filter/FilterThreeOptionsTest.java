package NotesOperations.Filter;

import Note.Note;
import NoteOperations.Filter.FilterThreeOptions;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@Ignore
public class FilterThreeOptionsTest {

    FilterThreeOptions filterThreeOptions;

    @Test
    public void filterByTitleAuthorContentOption_trueValue_trueValue() {
        String input = "a" + System.lineSeparator() + "b" + System.lineSeparator()
                + "c" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputStream savedStandardInputStream = System.in;
        System.setIn(in);

        List<Note> list = filterThreeOptions.filterByTitleAuthorContentOption("title, author, content")
                .orElse(null);

        System.setIn(savedStandardInputStream);

        assertThat("a", equalTo(list.get(0).getTitle()));
        assertThat("b", equalTo(list.get(0).getAuthor()));
        assertThat("c", equalTo(list.get(0).getContent()));
    }

    @Test
    public void filterByTitleAuthorContentOption_falseValue_falseValue() {
        String input = "n" + System.lineSeparator() + "m" + System.lineSeparator()
                + "z" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputStream savedStandardInputStream = System.in;
        System.setIn(in);

        List<Note> list = filterThreeOptions.filterByTitleAuthorContentOption("title, author, content")
                .orElse(null);

        System.setIn(savedStandardInputStream);

        assertTrue(list.isEmpty());
    }

}