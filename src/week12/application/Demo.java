package week12.application;

import week12.application.dummy.DummyApplication;
import week12.application.phonebook.PhoneBookApplication;

public class Demo {

    public static void main(String[] args) {
        Application app = new PhoneBookApplication("C:\\Users\\dindar.oz\\Desktop\\yasar\\lectures\\2024-Bahar\\SE 1106\\code\\s2\\temp\\myphonebook.pbk");

        app.run();

    }
}
