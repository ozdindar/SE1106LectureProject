package week12.application;

import week8.utils.ConsolUtils;

public class SplashScreen extends BaseScreen{
    public SplashScreen(String title, Screen returnScreen) {
        super(title, returnScreen);
    }

    @Override
    public Screen display() {

        displayContent();

        ConsolUtils.waitForEnter();

        return returnScreen;
    }

    protected void displayContent() {
        System.out.println(title);
    }
}
