import java.util.Scanner;

public class StringToInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            String input = sc.nextLine();   // user input as String

            int number = Integer.parseInt(input); // conversion
            System.out.println("Converted integer: " + number);

        } catch (NumberFormatException e) {
            System.out.println("Error: Input is not a valid integer");

        } catch (NullPointerException e) {
            System.out.println("Error: Input is null");

        } finally {
            sc.close();
        }
    }
}
