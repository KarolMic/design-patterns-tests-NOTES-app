package Note;

public class NoteProvider {

    private String title;
    private String author;
    private String content;

    public Note getNewNote(String title, String author, String content) {
        final Note note = new NoteBuilder()
                .withTitle(title)
                .withAuthor(author)
                .withContent(content)
                .build();
        return note;
    }

}
