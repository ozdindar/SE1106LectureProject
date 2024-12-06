package week12.application;

import week12.utils.ConsolUtils;

public abstract class ConsoleApplication implements Application{

    Screen currentScreen;

    @Override
    public void run() {
        currentScreen = init();

        while (currentScreen != null)
        {
            ConsolUtils.clearScreen();
            currentScreen = currentScreen.display();
        }

    }

    protected abstract Screen init();

}
