package NoteOperations.Filter;

import java.util.Scanner;

public class FilterOptionsMenu {

    private Scanner scanner = new Scanner(System.in);
    private String filterOption;

    public String filter() {
        System.out.println("How do you want to filter the notes? Type: ");
        System.out.println("\"title\" - if you want to search for note by title.");
        System.out.println("\"author\" - if you want to search for note by author.");
        System.out.println("\"content\" - if you want to search for note by content.");
        System.out.println("\"date\" - if you want to search for note by date.");
        System.out.println("\"title, author\" - if you want to search for note by title and author.");
        System.out.println("\"title, content\" - if you want to search for note by title and content.");
        System.out.println("\"title, date\" - if you want to search for note by title and date.");
        System.out.println("\"author, content\" - if you want to search for note by author and content.");
        System.out.println("\"author, date\" - if you want to search for note by author and date.");
        System.out.println("\"content, date\" - if you want to search for note by content and date.");
        System.out.println("\"title, author, content\" - if you want to search for note " +
                "by title, author and content.");
        System.out.println("\"title, author, content, date\" - if you want to search for note " +
                "by title, author, content and date.");
        filterOption = scanner.nextLine();
        if (filterOption.trim().isEmpty()) {
            throw new IllegalArgumentException("Illegal value");
        }
        return filterOption;
    }

}
