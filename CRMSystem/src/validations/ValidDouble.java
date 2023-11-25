package validations;

import java.util.Scanner;

public class ValidDouble {
    public static double validateDoubleInput(String message) {
        Scanner sc = new Scanner(System.in);
        double input = 0.00;
        boolean validInput = false;
        do {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                validInput = true;
            } else {
                System.out.println("Invalid input.");
            }
        } while (!validInput);

        return input;
    }
}
