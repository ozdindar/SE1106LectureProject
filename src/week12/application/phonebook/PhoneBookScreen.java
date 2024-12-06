package week12.application.phonebook;

import week12.application.BaseScreen;
import week12.application.Screen;

public abstract class PhoneBookScreen extends BaseScreen {

    PhoneBook phoneBook;

    public PhoneBookScreen(String title, Screen returnScreen, PhoneBook phoneBook) {
        super(title, returnScreen);
        this.phoneBook = phoneBook;
    }
}
