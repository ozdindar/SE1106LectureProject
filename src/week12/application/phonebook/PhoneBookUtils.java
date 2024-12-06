package week12.application.phonebook;

import week8.utils.ConsolUtils;

import java.util.List;

public class PhoneBookUtils {

    static final int COLUMN_WIDTH = 30;

    public static String tableHeader()
    {
        String header= String.format("%-"+COLUMN_WIDTH+"s %-"+COLUMN_WIDTH+"s %-"+COLUMN_WIDTH+"s\n", "Name", "City", "PhoneNumber");
        header += ConsolUtils.line(COLUMN_WIDTH*PhoneBookItem.COLUMN_COUNT);
        return header;
    }

    public static String  asTable(List<PhoneBookItem> items)
    {
        String table="";

        for (PhoneBookItem item:items)
        {
            table += String.format("%-"+COLUMN_WIDTH+"s %-"+COLUMN_WIDTH+"s %-"+COLUMN_WIDTH+"s\n", item.getName(), item.getCity(), item.getPhoneNumber());
        }

        return table;
    }
}
