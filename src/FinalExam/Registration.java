package FinalExam;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        StringBuilder valid = new StringBuilder(username);

        String commands = scanner.nextLine();
        while (!commands.equals("Registration")) {
            boolean replaced = true;

            String[] commandParts = commands.split("\\s+");
            String commandsName = commandParts[0];
            if (commandsName.equals("Letters")) {
                String lowerOrUpper = commandParts[1];
                if (lowerOrUpper.equals("Lower")) {
                    String userToLower = username.toLowerCase();
                    valid = new StringBuilder(userToLower);
                } else if (lowerOrUpper.equals("Upper")) {
                    String userToUpper = username.toLowerCase();
                    valid = new StringBuilder(userToUpper);
                }
            } else if (commandsName.equals("Reverse")) {
                int startIndex = Integer.parseInt(commandParts[1]);
                int endIndex = Integer.parseInt(commandParts[2]);
                if ((startIndex >= 0 && endIndex >= 0) && (startIndex <= valid.length() - 1 && endIndex <= valid.length() - 1) && startIndex <= endIndex) {
                    String substring = valid.substring(startIndex, endIndex + 1);
                    valid = new StringBuilder(substring);
                    valid.reverse();
                }
                //⦁	If the username contains the given substring,
                // cut it out and print the result without the cut substring.
            } else if (commandsName.equals("Substring")) {
                String substring = commandParts[1];
                String validToStr = valid.toString();
                if (validToStr.contains(substring)) {
                    validToStr = validToStr.replace(substring, "");
                    valid = new StringBuilder(validToStr);
                } else {
                    System.out.printf("The username %s doesn't contain %s.\n", valid, substring);
                    replaced = false;
                }
                //⦁	Replace all occurences of the given char with a dash (-) and print the result.
            } else if (commandsName.equals("Replace")) {
                char replacedChar = commandParts[1].charAt(0);
//                    String validToStr = valid.toString();
                for (char ch : username.toCharArray()) {
                    if (ch == replacedChar) {
                        username = username.replace(replacedChar, '-');
                        valid = new StringBuilder(username);
                    }
                }
            } else if (commandsName.equals("IsValid")) {
                String symbol = commandParts[1];
                String str = valid.toString();
                if (str.contains(symbol)) {
                    System.out.println("Valid username.");
                    replaced = false;
                } else {
                    System.out.printf("%s must be contained in your username.", symbol);
                    replaced = false;
                }
            }
            if (replaced) System.out.println(valid);
            commands = scanner.nextLine();
        }
    }
}
