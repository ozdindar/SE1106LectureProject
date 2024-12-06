package week12.application.dummy;

import week12.application.Screen;
import week12.application.SplashScreen;
import week8.utils.ConsolUtils;

public class DummyScreen extends SplashScreen {
    private static final String T_DUMMYAPP = "Dummy Application 0.1";


    public DummyScreen(Screen returnScreen) {
        super(T_DUMMYAPP, returnScreen);
    }

    @Override
    protected void displayContent() {
        System.out.println(ConsolUtils.colorize(title,ConsolUtils.YELLOW_BOLD_BRIGHT));
    }
}
