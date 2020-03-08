package Store;

import Note.Note;
import java.util.List;

public interface Storage {

    public List<Note> add(Note note);
    public List<Note> remove(Note note);
    public void display();
    public void filter();

}
