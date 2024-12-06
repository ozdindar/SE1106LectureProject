package week11.exceptions;

public class DemoDictionary {

    public static void main(String[] args) {

        try {
            DictionaryFile dFile = new DictionaryFile("C:\\Users\\dindar.oz\\Desktop\\yasar\\lectures\\2024-Bahar\\SE 1106\\code\\s2\\temp\\mydictionary.dic");

            String word = dFile.lookUp("Sword");
            System.out.println("Sword is "+ word);

        } catch (WrongDictionaryFileException e) {
            System.out.println("Error happened : "+e.getMessage());
        } catch (WordNotFoundException e) {
            System.out.println("Word not found");
        } catch (DictionaryIOException e) {
            System.out.println("Dictonary could not be read");;
        }
    }
}
