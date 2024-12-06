package week12.application.phonebook;

import week12.application.Screen;
import week12.application.SplashScreen;
import week8.utils.ConsolUtils;

import java.io.IOException;
import java.util.Scanner;

public class AddScreen extends PhoneBookScreen{

    public AddScreen(Screen returnScreen, PhoneBook phoneBook) {
        super("Add Item", returnScreen, phoneBook);
    }

    @Override
    public Screen display() {

        PhoneBookItem item = readFromUser();

        try {
            phoneBook.addItem(item);
        } catch (IOException e) {
            return new ErrorScreen("Input Output Error!",returnScreen);
        } catch (PhoneBookFileNotFoundException e) {
            return new ErrorScreen("PhoneBook file not found!",returnScreen);
        }



        return new SplashScreen("1 person added..",returnScreen);
    }

    private PhoneBookItem readFromUser() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsolUtils.colorize("New Person",ConsolUtils.CYAN_BOLD_BRIGHT));
        System.out.println(ConsolUtils.colorize("------------",ConsolUtils.CYAN_BOLD_BRIGHT));

        System.out.println(ConsolUtils.colorize("Name:",ConsolUtils.GREEN_BOLD_BRIGHT));
        String name = scanner.nextLine();

        System.out.println(ConsolUtils.colorize("City:",ConsolUtils.GREEN_BOLD_BRIGHT));
        String city = scanner.nextLine();

        System.out.println(ConsolUtils.colorize("Phone:",ConsolUtils.GREEN_BOLD_BRIGHT));
        String phone = scanner.nextLine();

        return new PhoneBookItem(name,city,phone);
    }
}
