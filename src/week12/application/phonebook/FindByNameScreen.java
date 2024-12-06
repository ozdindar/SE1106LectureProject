package week12.application.phonebook;

import week12.application.Screen;
import week8.utils.ConsolUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FindByNameScreen extends PhoneBookScreen {

    public FindByNameScreen(String title, Screen returnScreen, PhoneBook phoneBook) {
        super(title, returnScreen, phoneBook);
    }

    @Override
    public Screen display() {

        String name = readFromUser();
        try {
            List<PhoneBookItem> items = phoneBook.getItemsByName(name);

            displayHeader();
            displayItems(items);


        } catch (IOException e) {
            return new ErrorScreen("Input Output Error!",returnScreen);
        } catch (PhoneBookFileNotFoundException e) {
            return new ErrorScreen("PhoneBook file not found!",returnScreen);
        }

        ConsolUtils.waitForEnter();
        return returnScreen;
    }

    private void displayItems(List<PhoneBookItem> items) {
        String table = PhoneBookUtils.asTable(items);

        System.out.println(table);

        System.out.println(ConsolUtils.colorize("\n\n"+ items.size() + " items listed..",ConsolUtils.GREEN_BOLD_BRIGHT));


    }

    private void displayHeader() {
        System.out.println(ConsolUtils.colorize(PhoneBookUtils.tableHeader(),ConsolUtils.GREEN_BOLD_BRIGHT));

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
