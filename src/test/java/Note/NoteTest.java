package Note;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class NoteTest {

    @Test
    public void createNote_dateAutomaticallySet_dateNotNull() {
        Note note = new Note();

        boolean noteWithDate = note.getCreationDate() != null;

        assertThat(noteWithDate, equalTo(true));
    }

    @Test
    public void createNote_titleAutomaticallySet_TitleIsNull() {
        Note note = new Note();

        boolean noteWithDate = note.getTitle() == null;

        assertThat(noteWithDate, equalTo(true));
    }

    @Test
    public void createNote_authorAutomaticallySet_authorIsNull() {
        Note note = new Note();

        boolean noteWithDate = note.getAuthor() == null;

        assertThat(noteWithDate, equalTo(true));
    }

    @Test
    public void createNote_contentAutomaticallySet_TitleIsNull() {
        Note note = new Note();

        boolean noteWithDate = note.getContent() == null;

        assertThat(noteWithDate, equalTo(true));
    }

}