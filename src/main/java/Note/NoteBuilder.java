package Note;

public class NoteBuilder {

    private String title;
    private String author;
    private String content;

    public NoteBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public NoteBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public NoteBuilder withContent(String content) {
        this.content = content;
        return this;
    }

    public Note build() {
        Note note = new Note();
        note.setTitle(this.title);
        note.setAuthor(this.author);
        note.setContent(this.content);
        return note;
    }

}
