package NotesOperations.Display;

import NoteOperations.Display.NoteDisplay;
import NoteOperations.Display.NoteDisplayChoice;
import NoteOperations.Display.NoteDisplayFull;
import NoteOperations.Display.NoteDisplaySimple;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertEquals;

public class NoteDisplayChoiceTest {

    @Test
    public void setDisplayOption_FalseValue_IllegalValue() {
        String input = "" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        NoteDisplayChoice noteDisplayChoice = new NoteDisplayChoice();

        Throwable thrown = catchThrowable(noteDisplayChoice::setDisplayOption);
        assertThat(thrown).hasMessageContaining("Illegal value");
    }

    @Test
    public void setDisplayOption_trueStringValue_trueStringValue() {
        String input = "a" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        NoteDisplayChoice noteDisplayChoice = new NoteDisplayChoice();

        String field = noteDisplayChoice.setDisplayOption();
        assertEquals("a", field);
    }

    @Test
    public void createDisplayObject_passSimpleString_SimpleDisplay() {
        NoteDisplayChoice noteDisplayChoice = new NoteDisplayChoice();

        NoteDisplay noteDisplay = noteDisplayChoice.createDisplayObject("simple");

        assertEquals(NoteDisplaySimple.class, noteDisplay.getClass());
    }

    @Test
    public void createDisplayObject_passFullString_FullDisplay() {
        NoteDisplayChoice noteDisplayChoice = new NoteDisplayChoice();

        NoteDisplay noteDisplay = noteDisplayChoice.createDisplayObject("full");

        assertEquals(NoteDisplayFull.class, noteDisplay.getClass());
    }

    @Test
    public void createDisplayObject_wrongString_IleegalValue() {
        NoteDisplayChoice noteDisplayChoice = new NoteDisplayChoice();

        Throwable thrown = catchThrowable(() -> {
            noteDisplayChoice.createDisplayObject("");
        });
        assertThat(thrown).hasMessageContaining("Illegal value");
    }

}