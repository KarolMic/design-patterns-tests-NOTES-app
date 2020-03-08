package NoteOperations.Filter;

import Note.Note;
import NoteOperations.TypeFields;
import Store.SimpleStorage;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.util.Optional.empty;

public class FilterTwoOptions {

    private SimpleStorage simpleStorage = SimpleStorage.getInstance();
    private Scanner scanner = new Scanner(System.in);
    TypeFields typeFields = new TypeFields();

    public Optional<List<Note>> filterByTitleAuthorOption(String filterOption) {
        if (filterOption.equals("title, author")) {
            return Optional.of(simpleStorage.filterByTitleAuthor(typeFields.setTitle(), typeFields.setAuthor()));
        }
        return empty();
    }

    public Optional<List<Note>> filterByTitleContentOption(String filterOption) {
        if (filterOption.equals("title, content")) {
            return Optional.of(simpleStorage.filterByTitleContent(typeFields.setTitle(), typeFields.setContent()));
        }
        return empty();
    }

    public Optional<List<Note>> filterByTitleDateOption(String filterOption) {
        if (filterOption.equals("title, date")) {
            return Optional.of(simpleStorage.filterByTitleDate(typeFields.setTitle(), typeFields.setDate()));
        }
        return empty();
    }

    public Optional<List<Note>> filterByAuthorContentOption(String filterOption) {
        if (filterOption.equals("author, content")) {
            return Optional.of(simpleStorage.filterByAuthorContent(typeFields.setAuthor(), typeFields.setContent()));
        }
        return empty();
    }

    public Optional<List<Note>> filterByAuthorDateOption(String filterOption) {
        if (filterOption.equals("author, date")) {
            return Optional.of(simpleStorage.filterByAuthorDate(typeFields.setAuthor(), typeFields.setDate()));
        }
        return empty();
    }

    public Optional<List<Note>> filterByContentDateOption(String filterOption) {
        if (filterOption.equals("content, date")) {
            return Optional.of(simpleStorage.filterByContentDate(typeFields.setContent(), typeFields.setDate()));
        }
        return empty();
    }

}
