package week12.application.phonebook;

import week12.application.BaseScreen;
import week12.application.Screen;
import week8.utils.ConsolUtils;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuScreen extends BaseScreen {

    private static final String T_EXIT = "EXIT";

    List<Screen> options;

    public MenuScreen(String title, Screen returnScreen) {
        super(title, returnScreen);

        options = new ArrayList<>();
    }

    public void addOption(Screen option)
    {
        options.add(option);
    }

    @Override
    public Screen display() {

        displayMenu();
        int choice = readUserChoice();

        if (choice >= options.size())
            return returnScreen;
        else return options.get(choice);
    }

    private int readUserChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println(ConsolUtils.colorize("Enter a valid choice:",ConsolUtils.CYAN_BOLD_BRIGHT));
            choice = scanner.nextInt();
        } while (choice<1 || choice>options.size()+1);


        return choice-1;
    }

    private void displayMenu() {
        displayTitle();
        displayOptions();
    }

    private void displayOptions() {
        for (int o = 0; o < options.size(); o++) {
            System.out.print(ConsolUtils.colorize("["+(o+1)+"] ",ConsolUtils.CYAN_BOLD_BRIGHT));
            System.out.println(options.get(o).getTitle());
        }
        System.out.print(ConsolUtils.colorize("["+(options.size()+1)+"] ",ConsolUtils.CYAN_BOLD_BRIGHT));
        if (returnScreen== null)
            System.out.println(ConsolUtils.colorize(T_EXIT,ConsolUtils.YELLOW_BOLD_BRIGHT));
        else System.out.println(ConsolUtils.colorize(returnScreen.getTitle(),ConsolUtils.YELLOW_BOLD_BRIGHT));
    }

    private void displayTitle() {
        System.out.println(ConsolUtils.colorize(title,ConsolUtils.CYAN_BOLD_BRIGHT));
        System.out.println(ConsolUtils.colorize(ConsolUtils.line(title.length()*2),ConsolUtils.CYAN_BOLD_BRIGHT));
    }
}
