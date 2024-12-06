package week12.application.phonebook;

import week12.application.Screen;
import week12.application.SplashScreen;
import week8.utils.ConsolUtils;

public class PhoneBookIntroScreen extends SplashScreen {
    private final String intro= "\n\n\n\n.______    __    __    ______   .__   __.  _______ .______     ______     ______    __  ___ \n" +
            "|   _  \\  |  |  |  |  /  __  \\  |  \\ |  | |   ____||   _  \\   /  __  \\   /  __  \\  |  |/  / \n" +
            "|  |_)  | |  |__|  | |  |  |  | |   \\|  | |  |__   |  |_)  | |  |  |  | |  |  |  | |  '  /  \n" +
            "|   ___/  |   __   | |  |  |  | |  . `  | |   __|  |   _  <  |  |  |  | |  |  |  | |    <   \n" +
            "|  |      |  |  |  | |  `--'  | |  |\\   | |  |____ |  |_)  | |  `--'  | |  `--'  | |  .  \\  \n" +
            "| _|      |__|  |__|  \\______/  |__| \\__| |_______||______/   \\______/   \\______/  |__|\\__\\ \n" +
            "                                                                                            ";

    public PhoneBookIntroScreen(String title, Screen returnScreen) {
        super(title, returnScreen);
    }

    @Override
    protected void displayContent() {
        System.out.println(ConsolUtils.colorize(intro,ConsolUtils.CYAN_BOLD_BRIGHT));
    }
}
