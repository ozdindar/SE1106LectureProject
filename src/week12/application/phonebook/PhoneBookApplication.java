package week12.application.phonebook;

import week12.application.ConsoleApplication;
import week12.application.Screen;
import week12.application.SplashScreen;

public class PhoneBookApplication extends ConsoleApplication {

    private static final String T_PHONEBOOK = "PhoneBook 1.0";

    PhoneBook phoneBook;

    public PhoneBookApplication(String phonebookFile) {
        phoneBook = new PhoneBook(phonebookFile);
    }

    @Override
    protected Screen init() {

        MenuScreen mainmenu =  new MenuScreen("Main Menu",null);

        mainmenu.addOption(new ListScreen(mainmenu,phoneBook));
        mainmenu.addOption(new AddScreen(mainmenu,phoneBook));
        mainmenu.addOption(new RemoveScreen(mainmenu,phoneBook));

        MenuScreen findMenu = new MenuScreen("Find By..",mainmenu);
        findMenu.addOption(new FindByNameScreen("By Name..",mainmenu, phoneBook));
        findMenu.addOption(new SplashScreen("By City..",mainmenu));

        mainmenu.addOption(findMenu);

        Screen intro = new PhoneBookIntroScreen(T_PHONEBOOK,mainmenu);

        return intro;
    }
}
