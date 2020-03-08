package NoteOperations;

import java.util.Scanner;

public class TypeFields {

    Scanner scanner = new Scanner(System.in);
    String title;
    String author;
    String content;

    public String setTitle() {
        System.out.printf("Type title: ");
        title = scanner.nextLine();
        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("Illegal value");
        }
        return title;
    }

    public String setAuthor() {
        System.out.printf("Type author: ");
        author = scanner.nextLine();
        if (author.trim().isEmpty()) {
            throw new IllegalArgumentException("Illegal value");
        }
        return author;
    }

    public String setContent() {
        System.out.printf("Type content: ");
        content = scanner.nextLine();
        if (content.trim().isEmpty()) {
            throw new IllegalArgumentException("Illegal value");
        }
        return content;
    }

    public String setDate() {
        System.out.printf("Type date: ");
        content = scanner.nextLine();
        if (content.trim().isEmpty()) {
            throw new IllegalArgumentException("Illegal value");
        }
        return content;
    }

}
