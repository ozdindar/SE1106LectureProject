package week12.application.phonebook;

import week12.application.Screen;
import week12.application.SplashScreen;
import week8.utils.ConsolUtils;

import java.util.Scanner;

public class RemoveScreen extends PhoneBookScreen {

    public RemoveScreen( Screen returnScreen, PhoneBook phoneBook) {
        super("Remove Item..", returnScreen, phoneBook);
    }

    @Override
    public Screen display() {

        String name = readFromUser();

        int removedItems = phoneBook.removeItemsByName(name);

        return new SplashScreen(removedItems + " persons removed..",returnScreen);
    }

    private String readFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsolUtils.colorize("Remove Person",ConsolUtils.CYAN_BOLD_BRIGHT));
        System.out.println(ConsolUtils.colorize("------------",ConsolUtils.CYAN_BOLD_BRIGHT));

        System.out.println(ConsolUtils.colorize("Name:",ConsolUtils.GREEN_BOLD_BRIGHT));
        String name = scanner.nextLine();

        return name;
    }
}
