package Store;

import Note.Note;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ToString
public final class SimpleStorage {

    private static final SimpleStorage INSTANCE = new SimpleStorage();
    private List<Note> notes = new ArrayList<>();

    public SimpleStorage() {
    }

    public static SimpleStorage getInstance() {
        return INSTANCE;
    }

    public void add(Note note) {
        notes.add(note);
    }

    public boolean remove(List<Note> filteredNotes) {
        if (notes.containsAll(filteredNotes)) {
            return notes.removeAll(filteredNotes);
        }
        return false;
    }

    public void display() {
        notes.stream().forEach(System.out::println);
    }

    public List<Note> filterByTitle(String title) {
        return notes.stream()
                .filter(e -> e.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public List<Note> filterByAuthor(String author) {
        return notes.stream()
                .filter(e -> e.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Note> filterByDate(String date) {
        return notes.stream()
                .filter(e -> e.getCreationDate().contains(date))
                .collect(Collectors.toList());
    }

    public List<Note> filterByContent(String content) {
        return notes.stream()
                .filter(e -> e.getContent().equals(content))
                .collect(Collectors.toList());
    }

    public List<Note> filterByTitleAuthor(String title, String author) {
        return notes.stream()
                .filter(e -> e.getTitle().equals(title))
                .filter(e -> e.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Note> filterByTitleContent(String title, String content) {
        return notes.stream()
                .filter(e -> e.getTitle().equals(title))
                .filter(e -> e.getContent().equals(content))
                .collect(Collectors.toList());
    }

    public List<Note> filterByTitleDate(String title, String date) {
        return notes.stream()
                .filter(e -> e.getTitle().equals(title))
                .filter(e -> e.getCreationDate().contains(date))
                .collect(Collectors.toList());
    }

    public List<Note> filterByAuthorContent(String author, String content) {
        return notes.stream()
                .filter(e -> e.getAuthor().equals(author))
                .filter(e -> e.getContent().equals(content))
                .collect(Collectors.toList());
    }

    public List<Note> filterByAuthorDate(String author, String date) {
        return notes.stream()
                .filter(e -> e.getAuthor().equals(author))
                .filter(e -> e.getCreationDate().contains(date))
                .collect(Collectors.toList());
    }

    public List<Note> filterByContentDate(String content, String date) {
        return notes.stream()
                .filter(e -> e.getContent().equals(content))
                .filter(e -> e.getCreationDate().contains(date))
                .collect(Collectors.toList());
    }

    public List<Note> filterByTitleAuthorContent(String title, String author, String content) {
        return notes.stream()
                .filter(e -> e.getTitle().equals(title))
                .filter(e -> e.getAuthor().equals(author))
                .filter(e -> e.getContent().equals(content))
                .collect(Collectors.toList());
    }

    public List<Note> filterByTitleAuthorContentDate(String title, String author, String content, String date) {
        return notes.stream()
                .filter(e -> e.getTitle().equals(title))
                .filter(e -> e.getAuthor().equals(author))
                .filter(e -> e.getContent().equals(content))
                .filter(e -> e.getCreationDate().contains(date))
                .collect(Collectors.toList());
    }

    public List<Note> getNotes() {
        return Collections.unmodifiableList(notes);
    }
}