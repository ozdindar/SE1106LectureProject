package week12.application;

public abstract class BaseScreen implements Screen {
    protected String title;
    protected Screen returnScreen;

    public BaseScreen(String title, Screen returnScreen) {
        this.title = title;
        this.returnScreen = returnScreen;
    }

    public String getTitle() {
        return title;
    }

    public Screen getReturnScreen() {
        return returnScreen;
    }
}
