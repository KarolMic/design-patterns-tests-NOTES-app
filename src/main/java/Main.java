import NoteOperations.Add.AddNote;
import NoteOperations.Display.NoteDisplayChoice;
import NoteOperations.Display.NoteDisplaySimple;
import NoteOperations.Filter.*;
import Store.SimpleStorage;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SimpleStorage simpleStorage = SimpleStorage.getInstance();
        FilterOptionsMenu filterOptions = new FilterOptionsMenu();
        FilterOneOption filterOneOption = new FilterOneOption();
        FilterTwoOptions filterTwoOptions = new FilterTwoOptions();
        FilterThreeOptions filterThreeOptions = new FilterThreeOptions();
        FilterFourOptions filterFourOptions = new FilterFourOptions();
        NoteDisplayChoice noteDisplayChoice = new NoteDisplayChoice();
        AddNote addNote = new AddNote();
        NoteDisplaySimple noteDisplaySimple = new NoteDisplaySimple();

        Scanner scanner = new Scanner(System.in);
        String option = "a";
        String filterOption;

        while(option != null) {
            applicationMenu();
            option = scanner.nextLine();
            switch (option) {
                case "add":
                    addNote.addNote();
                    break;
                case "display":
                    noteDisplayChoice.displayChoice(simpleStorage.getNotes());
                    break;
                case "filter":
                    filterOption = filterOptions.filter();

                    noteDisplayChoice.displayChoice(filterOneOption.filterByTitleOption(filterOption)
                            .orElse(Collections.emptyList()));

                    noteDisplayChoice.displayChoice(filterOneOption.filterByAuthorOption(filterOption)
                            .orElse(Collections.emptyList()));

                    noteDisplayChoice.displayChoice(filterOneOption.filterByContentOption(filterOption)
                            .orElse(Collections.emptyList()));

                    noteDisplayChoice.displayChoice(filterOneOption.filterByDateOption(filterOption)
                            .orElse(Collections.emptyList()));

                    noteDisplayChoice.displayChoice(filterTwoOptions.filterByTitleAuthorOption(filterOption)
                            .orElse(Collections.emptyList()));

                    noteDisplayChoice.displayChoice(filterTwoOptions.filterByTitleContentOption(filterOption)
                            .orElse(Collections.emptyList()));

                    noteDisplayChoice.displayChoice(filterTwoOptions.filterByTitleDateOption(filterOption)
                            .orElse(Collections.emptyList()));

                    noteDisplayChoice.displayChoice(filterTwoOptions.filterByAuthorContentOption(filterOption)
                            .orElse(Collections.emptyList()));

                    noteDisplayChoice.displayChoice(filterTwoOptions.filterByAuthorDateOption(filterOption)
                            .orElse(Collections.emptyList()));

                    noteDisplayChoice.displayChoice(filterTwoOptions.filterByContentDateOption(filterOption)
                            .orElse(Collections.emptyList()));

                    noteDisplayChoice.displayChoice(filterThreeOptions.filterByTitleAuthorContentOption(filterOption)
                            .orElse(Collections.emptyList()));

                    noteDisplayChoice.displayChoice(
                            filterFourOptions.filterByTitleAuthorContentDateOption(filterOption)
                                    .orElse(Collections.emptyList()));

                    break;
                case "remove":
                    System.out.println("All notes displayed with simple way: ");
                    noteDisplaySimple.display(simpleStorage.getNotes());
                    System.out.println("If you want to remove specific note, you have to filter all notes: ");
                    filterOption = filterOptions.filter();

                    simpleStorage.remove(filterOneOption.filterByTitleOption(filterOption)
                            .orElse(Collections.emptyList()));

                    simpleStorage.remove(filterOneOption.filterByAuthorOption(filterOption)
                            .orElse(Collections.emptyList()));

                    simpleStorage.remove(filterOneOption.filterByContentOption(filterOption)
                            .orElse(Collections.emptyList()));

                    simpleStorage.remove(filterOneOption.filterByDateOption(filterOption)
                            .orElse(Collections.emptyList()));

                    simpleStorage.remove(filterTwoOptions.filterByTitleAuthorOption(filterOption)
                            .orElse(Collections.emptyList()));

                    simpleStorage.remove(filterTwoOptions.filterByTitleContentOption(filterOption)
                            .orElse(Collections.emptyList()));

                    simpleStorage.remove(filterTwoOptions.filterByTitleDateOption(filterOption)
                            .orElse(Collections.emptyList()));

                    simpleStorage.remove(filterTwoOptions.filterByAuthorContentOption(filterOption)
                            .orElse(Collections.emptyList()));

                    simpleStorage.remove(filterTwoOptions.filterByAuthorDateOption(filterOption)
                            .orElse(Collections.emptyList()));

                    simpleStorage.remove(filterTwoOptions.filterByContentDateOption(filterOption)
                            .orElse(Collections.emptyList()));

                    simpleStorage.remove(filterThreeOptions.filterByTitleAuthorContentOption(filterOption)
                            .orElse(Collections.emptyList()));

                    simpleStorage.remove(filterFourOptions.filterByTitleAuthorContentDateOption(filterOption)
                            .orElse(Collections.emptyList()));
                    break;
            }
        }
    }

    private static void applicationMenu() {
        System.out.println("---------- APPLICATION MENU ----------");
        System.out.println("To perform the appropriate operations, type: ");
        System.out.println("\"add\" - to add new note.");
        System.out.println("\"display\" - to display all notes.");
        System.out.println("\"filter\" - to filter all notes, and then display filtered notes.");
        System.out.println("\"remove\" - to remove filtered notes.");
    }

}
