package NoteOperations.Filter;

import Note.Note;
import NoteOperations.TypeFields;
import Store.SimpleStorage;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;

public class FilterThreeOptions {

    private SimpleStorage simpleStorage = SimpleStorage.getInstance();
    private TypeFields typeFields = new TypeFields();

    public Optional<List<Note>> filterByTitleAuthorContentOption(String filterOption) {
        if (filterOption.equals("title, author, content")) {
            return Optional.of(simpleStorage.filterByTitleAuthorContent(typeFields.setTitle(),
                    typeFields.setAuthor(), typeFields.setContent()));
        }
        return empty();
    }

}
