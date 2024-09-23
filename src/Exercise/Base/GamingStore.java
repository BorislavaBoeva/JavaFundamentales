package Exercise.Base;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        double currentBalance = budget;
        String input;
        double GamePrice;
        double totalSpent = 0;

        while (!"Game Time".equals(input = scanner.nextLine())) {

            if (input.equals("OutFall 4")) {
                GamePrice = 39.99;
                if (GamePrice <= currentBalance) {
                    System.out.printf("Bought %s\n", input);
                    totalSpent += GamePrice;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (input.equals("CS: OG")) {
                GamePrice = 15.99;
                if (GamePrice <= currentBalance) {
                    System.out.printf("Bought %s\n", input);
                    totalSpent += GamePrice;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (input.equals("Zplinter Zell")) {
                GamePrice = 19.99;
                if (GamePrice <= currentBalance) {
                    System.out.printf("Bought %s\n", input);
                    totalSpent += GamePrice;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (input.equals("Honored 2")) {
                GamePrice = 59.99;
                if (GamePrice <= currentBalance) {
                    System.out.printf("Bought %s\n", input);
                    totalSpent += GamePrice;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (input.equals("RoverWatch")) {
                GamePrice = 29.99;
                if (GamePrice <= currentBalance) {
                    System.out.printf("Bought %s\n", input);
                    totalSpent += GamePrice;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (input.equals("RoverWatch Origins Edition")) {
                GamePrice = 39.99;
                if (GamePrice <= currentBalance) {
                    System.out.printf("Bought %s\n", input);
                    totalSpent += GamePrice;
                } else {
                    System.out.println("Too Expensive");
                }
            } else {
                System.out.println("Not Found");
            }
            currentBalance -= totalSpent;
        }

        double diff = budget - totalSpent;
        if (diff <= 0.00) {
                System.out.println("Out of money!");
        } else {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f\n", totalSpent, diff);
        }
    }
}