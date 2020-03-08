package NoteOperations.Filter;

import Note.Note;
import NoteOperations.TypeFields;
import Store.SimpleStorage;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;

public class FilterOneOption {

    private SimpleStorage simpleStorage = SimpleStorage.getInstance();
    private TypeFields typeFields = new TypeFields();

    public Optional<List<Note>> filterByTitleOption(String filterOption) {
        if (filterOption.equals("title")) {
            return Optional.of(simpleStorage.filterByTitle(typeFields.setTitle()));
        }
        return empty();
    }

    public Optional<List<Note>> filterByAuthorOption(String filterOption) {
        if (filterOption.equals("author")) {
            return Optional.of(simpleStorage.filterByAuthor(typeFields.setAuthor()));
        }
        return empty();
    }

    public Optional<List<Note>> filterByContentOption(String filterOption) {
        if (filterOption.equals("content")) {
            return Optional.of(simpleStorage.filterByContent(typeFields.setContent()));
        }
        return empty();
    }

    public Optional<List<Note>> filterByDateOption(String filterOption) {
        if (filterOption.equals("date")) {
            return Optional.of(simpleStorage.filterByDate(typeFields.setDate()));
        }
        return empty();
    }

}
