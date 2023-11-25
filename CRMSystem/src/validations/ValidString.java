package validations;

import java.util.Scanner;

public class ValidString {
    public static String validateStringInput(String message) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        do {
            System.out.print(message);
            input = sc.nextLine().trim();
            if (input.isEmpty() || input.equals(" ") || input.equals(",")) {
                System.out.println("Invalid input.");
            }
        } while (input.isEmpty());

        return input;
    }
}
