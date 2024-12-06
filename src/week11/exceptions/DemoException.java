package week11.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DemoException {

    public static void main(String[] args) {

        System.out.println(1);
        try {
            System.out.println(2);
            demo1();
            System.out.println(3);
            demo1();

        }catch ( FileNotFoundException fnfe)
        {
            System.out.println("The file could not be found!");
            try {
                System.out.println(6);
                demo1();
                System.out.println(7);
            } catch (IOException e) {
                System.out.println(8);

            }
        }
        catch ( IOException ioe)
        {
            System.out.println("an IO exception occurred!");
        }

        System.out.println(4);
    }

    private static void demo1() throws FileNotFoundException,IOException {
        String line = DemoFileOperations.readOneLine("C:\\Users\\dindar.oz\\Desktop\\yasar\\lectures\\2024-Bahar\\SE 1106\\code\\s2\\temp\\temp2.txt");
        System.out.println(line);
    }
}
