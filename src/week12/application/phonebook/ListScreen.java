package week12.application.phonebook;

import week12.application.Screen;
import week8.utils.ConsolUtils;

import java.io.IOException;
import java.util.List;

public class ListScreen extends PhoneBookScreen {

    private static final String T_LISTITEMS = "Item List";

    public ListScreen( Screen returnScreen, PhoneBook phoneBook) {
        super(T_LISTITEMS, returnScreen, phoneBook);
    }

    @Override
    public Screen display() {
        try {
            List<PhoneBookItem> items = phoneBook.getItems();

            displayHeader();
            displayItems(items);


        } catch (IOException e) {
            return new ErrorScreen("Input Output Error!",returnScreen);
        } catch (PhoneBookFileNotFoundException e) {
            return new ErrorScreen("PhoneBook file not found!",returnScreen);
        } catch (Exception e )
        {
            return new ErrorScreen(e.getMessage(),returnScreen);
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
}
