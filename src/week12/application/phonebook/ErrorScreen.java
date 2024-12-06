package week12.application.phonebook;

import week12.application.Screen;
import week12.application.SplashScreen;
import week8.utils.ConsolUtils;

public class ErrorScreen extends SplashScreen {
    public ErrorScreen(String title, Screen returnScreen) {
        super(title, returnScreen);
    }

    @Override
    protected void displayContent() {
        System.out.println(ConsolUtils.colorize("ERROR:",ConsolUtils.RED_BOLD_BRIGHT));
        System.out.println(title);
    }
}
