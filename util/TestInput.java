package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestInput {
    Scanner input = new Scanner(System.in);

    // Test the input of the user
    public int TestInt(int min, int max) {
        while (true) {
            try {
                int choice = input.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println(input + " is not a valid choice. Please select a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number. \n" + e);
                input.nextLine();
            }
        }
    }

    public String TestLine() {
        while (true) {
            try {
                String choice = input.nextLine();
                if (choice.isEmpty()) {
                    System.out.println("Please enter a string.");
                    continue;               
                } else {
                    return choice;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a string. \n" + e);
                input.nextLine();
            }
        }
    }

    public char TestChar(char[] chars){
        while (true) {
            
            try {
                char testChar = input.next().toLowerCase().charAt(0);
                return testChar;
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
