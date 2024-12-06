package week11.exceptions;

import java.io.*;
import java.util.Locale;

public class DictionaryFile {

    public DictionaryFile(String dictionaryFileName) throws WrongDictionaryFileException{

        if ( !dictionaryFileName.endsWith(".dic"))
        {
            throw  new WrongDictionaryFileException(dictionaryFileName+ "  is not a proper dictionary name");

        }


        this.dictionaryFileName = dictionaryFileName;

    }

    /**
     * Returns the meaning of the word in the dictionary
     * @param word
     * @return
     * @throws   WordNotFoundException if the given word is not in the Dictionary
     */
    String lookUp(String word) throws WrongDictionaryFileException, DictionaryIOException, WordNotFoundException {

        try {
            FileReader fileReader = new FileReader(dictionaryFileName);
            BufferedReader bReader = new BufferedReader(fileReader);

            String line = bReader.readLine();

            word = word.toLowerCase(Locale.ROOT);

            while (line != null)
            {
                if (line.startsWith(word+":"))
                {
                    return line.substring(word.length()+1);
                }
                line = bReader.readLine();
            }

            throw new WordNotFoundException( word + " is not found in the dictionary!");


        } catch (FileNotFoundException e) {
            throw new WrongDictionaryFileException("Dictionary file (" +dictionaryFileName+") is not found.");
        } catch (IOException e) {
            throw new DictionaryIOException();
        }

    }

    String dictionaryFileName;


}
