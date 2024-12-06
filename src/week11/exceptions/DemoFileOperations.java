package week11.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DemoFileOperations {

    public static String readOneLine( String fileName) throws FileNotFoundException, IOException
    {
        FileReader fReader = new FileReader(fileName);
        BufferedReader bReader =  new BufferedReader(fReader);

        String line = bReader.readLine();

        fReader.close();

        return line;
    }
}
