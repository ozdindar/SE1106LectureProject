package week12.application.phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook
{
    List<PhoneBookItem> items;
    String phoneBookFile;

    boolean loaded;


    public PhoneBook(String phoneBookFile)  {
        this.phoneBookFile = phoneBookFile;

        loaded = false;

    }


    void loadItems() throws PhoneBookFileNotFoundException, IOException {
        if (loaded)
            return;

        items = new ArrayList<>();

        try {
            FileReader fReader = new FileReader(phoneBookFile);
            BufferedReader bReader = new BufferedReader(fReader);

            String line = bReader.readLine();

            while (line != null)
            {
                items.add( PhoneBookItem.fromPhoneBookLine(line));
                line = bReader.readLine();
            }

            fReader.close();
            loaded = true;

        } catch (FileNotFoundException e) {
            throw new PhoneBookFileNotFoundException();
        }

    }



    void saveItems() throws IOException {
        FileWriter fWriter = new FileWriter(phoneBookFile);
        BufferedWriter bWriter = new BufferedWriter(fWriter);

        for (PhoneBookItem item:items)
        {
            bWriter.write(item.toPhoneBookLine()+"\n");
        }
        bWriter.close();
        fWriter.close();
    }

    public List<PhoneBookItem> getItems() throws IOException, PhoneBookFileNotFoundException {

        loadItems();
        return items;
    }


    public void addItem(PhoneBookItem item) throws IOException, PhoneBookFileNotFoundException {
        loadItems();
        items.add(item);
        saveItems();
    }

    public void removeItem(PhoneBookItem item) throws IOException, PhoneBookFileNotFoundException {
        loadItems();
        items.remove(item);
        saveItems();
    }

    public int removeItemsByName(String name) {

        List<PhoneBookItem> toBeRemoved =new ArrayList<>();

        for (PhoneBookItem item: items)
        {
            if (item.getName().startsWith(name))
                toBeRemoved.add(item);
        }

        items.removeAll(toBeRemoved);

        return toBeRemoved.size();
    }

    public List<PhoneBookItem> getItemsByName(String name) throws IOException, PhoneBookFileNotFoundException {

        loadItems();

        List<PhoneBookItem> searchedItems =new ArrayList<>();

        for (PhoneBookItem item: items)
        {
            if (item.getName().startsWith(name))
                searchedItems.add(item);
        }
        return searchedItems;
    }
}
