package week12.application.phonebook;

public class PhoneBookItem {
    private static final String DELIMITER = ":";
    public static final int COLUMN_COUNT = 3;

    String name;
    String city;
    String phoneNumber;

    public PhoneBookItem(String name, String city, String phoneNumber) {
        this.name = name;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + " " + city + " " + phoneNumber;
    }


    public String toPhoneBookLine()
    {
        return name + DELIMITER + city + DELIMITER + phoneNumber;
    }

    public static PhoneBookItem fromPhoneBookLine(String line)
    {
        String[] tokens = line.split(DELIMITER);

        if (tokens.length != COLUMN_COUNT)
            throw new WrongPhoneBookLineException(line + " does not contain "+ COLUMN_COUNT +" tokens");

        return new PhoneBookItem(tokens[0],tokens[1],tokens[2]);

    }


}
