package Note;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class NoteBuilderTest {

    @Test
    public void buildNote_withTrueValues_noteWithTrueValues() {
        NoteBuilder noteBuilder = new NoteBuilder();
        noteBuilder.withTitle("a");
        noteBuilder.withAuthor("b");
        noteBuilder.withContent("c");
        Note note = noteBuilder.build();

        assertThat("a", equalTo(note.getTitle()));
        assertThat("b", equalTo(note.getAuthor()));
        assertThat("c", equalTo(note.getContent()));
    }

}