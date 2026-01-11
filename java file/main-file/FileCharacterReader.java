import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileCharacterReader {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileReader reader = null;
        int charCount = 0;

        try {
            System.out.print("Enter file path: ");
            String filePath = sc.nextLine();

            reader = new FileReader(filePath);
            int ch;

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
                charCount++;
            }

            System.out.println("\nTotal number of characters: " + charCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                sc.close();
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }
}
