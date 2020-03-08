package NoteOperations.Display;

import Note.Note;

import java.util.List;
import java.util.Scanner;

public class NoteDisplayChoice {

    private NoteDisplay noteDisplay = null;
    private Scanner scanner = new Scanner(System.in);
    private String displayOption;

    public void displayChoice(List<Note> notes) {

        if (!notes.isEmpty()) {
            System.out.println("How do you want to display the note? Type: ");
            System.out.println("\"simple\" - if you want to display only title and author.");
            System.out.println("\"full\" - if you want to display all fields.");
            displayOption = setDisplayOption();

            createDisplayObject(displayOption);

            noteDisplay.display(notes);
        }
    }

    public String setDisplayOption() {
        displayOption = scanner.nextLine();
        if (displayOption.trim().isEmpty()) {
            throw new IllegalArgumentException("Illegal value");
        }
        return displayOption;
    }

    public NoteDisplay createDisplayObject(String displayOption) {
        if ("simple".equals(displayOption)) {
            return noteDisplay = new NoteDisplaySimple();
        } else if ("full".equals(displayOption)) {
            return noteDisplay = new NoteDisplayFull();
        }
        throw new IllegalArgumentException("Illegal value");
    }

}
