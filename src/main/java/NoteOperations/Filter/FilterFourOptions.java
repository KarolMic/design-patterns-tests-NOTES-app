package NoteOperations.Filter;

import Note.Note;
import NoteOperations.TypeFields;
import Store.SimpleStorage;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;

public class FilterFourOptions {

    private SimpleStorage simpleStorage = SimpleStorage.getInstance();
    private TypeFields typeFields = new TypeFields();

    public Optional<List<Note>> filterByTitleAuthorContentDateOption(String filterOption) {
        if (filterOption.equals("title, author, content, date")) {
            return Optional.of(simpleStorage.filterByTitleAuthorContentDate(typeFields.setTitle(),
                    typeFields.setAuthor(), typeFields.setContent(), typeFields.setDate()));
        }
        return empty();
    }

}
