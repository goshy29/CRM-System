package validations;

import java.util.Scanner;

public class ValidInt {
    public static int validateIntegerInput(String message) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;
        do {
            System.out.print(message);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input.");
                sc.next();
            }
        } while (!validInput);

        return input;
    }
}
