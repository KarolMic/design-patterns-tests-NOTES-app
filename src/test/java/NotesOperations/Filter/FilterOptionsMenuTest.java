package NotesOperations.Filter;

import NoteOperations.Filter.FilterOptionsMenu;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertEquals;

public class FilterOptionsMenuTest {

    @Test
    public void filter_stringValue_StringValue() {
        String input = "c" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FilterOptionsMenu filterOptionsMenu = new FilterOptionsMenu();

        String option = filterOptionsMenu.filter();

        assertEquals("c", option);
    }

    @Test
    public void filter_illegalValue_illegalValue() {
        String input = "" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FilterOptionsMenu filterOptionsMenu = new FilterOptionsMenu();

        Throwable thrown = catchThrowable(filterOptionsMenu::filter);
        assertThat(thrown).hasMessageContaining("Illegal value");
    }

}