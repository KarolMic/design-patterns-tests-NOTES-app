package NotesOperations;

import NoteOperations.TypeFields;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertEquals;

public class TypeFieldsTest {

    @Test
    public void setTitle_isEmpty_IleegalArgument() {
        String input = "" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TypeFields typeFields = new TypeFields();

        Throwable thrown = catchThrowable(typeFields::setTitle);
        assertThat(thrown).hasMessageContaining("Illegal value");
    }

    @Test
    public void setTitle_setString_String() {
        String input = "a" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TypeFields typeFields = new TypeFields();

        String field = typeFields.setTitle();

        assertEquals("a", field);
    }

    @Test
    public void setAuthor_isEmpty_IleegalArgument() {
        String input = "" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TypeFields typeFields = new TypeFields();

        Throwable thrown = catchThrowable(typeFields::setAuthor);
        assertThat(thrown).hasMessageContaining("Illegal value");
    }

    @Test
    public void setAuthor_setString_String() {
        String input = "b" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TypeFields typeFields = new TypeFields();

        String field = typeFields.setAuthor();

        assertEquals("b", field);
    }

    @Test
    public void setContent_isEmpty_IleegalArgument() {
        String input = "" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TypeFields typeFields = new TypeFields();

        Throwable thrown = catchThrowable(typeFields::setContent);
        assertThat(thrown).hasMessageContaining("Illegal value");
    }

    @Test
    public void setContent_setString_String() {
        String input = "c" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TypeFields typeFields = new TypeFields();

        String field = typeFields.setContent();

        assertEquals("c", field);
    }

    @Test
    public void setDate_isEmpty_IleegalArgument() {
        String input = "" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TypeFields typeFields = new TypeFields();

        Throwable thrown = catchThrowable(typeFields::setDate);
        assertThat(thrown).hasMessageContaining("Illegal value");
    }

    @Test
    public void setDate_setString_String() {
        String input = "c" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TypeFields typeFields = new TypeFields();

        String field = typeFields.setDate();

        assertEquals("c", field);
    }

}