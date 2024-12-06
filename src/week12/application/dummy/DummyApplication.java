package week12.application.dummy;

import week12.application.ConsoleApplication;
import week12.application.Screen;

public class DummyApplication extends ConsoleApplication {
    @Override
    protected Screen init() {
        return new DummyScreen(null);
    }
}
