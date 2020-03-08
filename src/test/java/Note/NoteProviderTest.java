package Note;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class NoteProviderTest {

    @Test
    public void provideNote_withTrueValues_noteWithTrueValues() {
        NoteProvider noteProvider = new NoteProvider();

        Note note = noteProvider.getNewNote("a", "b", "c");

        assertThat("a", equalTo(note.getTitle()));
        assertThat("b", equalTo(note.getAuthor()));
        assertThat("c", equalTo(note.getContent()));
    }

}