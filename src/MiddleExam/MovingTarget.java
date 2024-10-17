package MiddleExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String commands = scanner.nextLine();

        while (!commands.equals("End")) {

            String[] commandParts = commands.split(" ");
            String commandName = commandParts[0];

            if (commandName.equals("Shoot")) {
                int index = Integer.parseInt(commandParts[1]);
                int power = Integer.parseInt(commandParts[2]);
                if (isValidIndex(index, targets.size() - 1)) {
                    int target = targets.get(index);
                    target -= power;
                    if (target > power) {
                        targets.set(index, target);
                    } else if (target <= 0) {
                        targets.remove(index);
                    }
                }
            } else if (commandName.equals("Add")) {
                int index = Integer.parseInt(commandParts[1]);
                int power = Integer.parseInt(commandParts[2]);
                if (!isValidIndex(index, targets.size() - 1)) {
                    System.out.println("Invalid placement!");
                } else {
                    targets.add(index, power);
                }
            } else if (commandName.equals("Strike")) {
                int index = Integer.parseInt(commandParts[1]);
                int radius = Integer.parseInt(commandParts[2]);

                int target = targets.get(index);
                int beforeTarget = (index - radius);
                int afterTarget = (index + radius);

                if ((isValidIndex(beforeTarget, targets.size() - 1)) && (isValidIndex(afterTarget, targets.size() - 1)) && (isValidIndex(index, targets.size() - 1))) {
                    for (int i = afterTarget; i >= beforeTarget; i--) {
                        targets.remove(i);
                    }
                } else {
                    System.out.println("Strike missed!");
                }
            }

            commands = scanner.nextLine();
        }

        for (int target = 0; target <= targets.size() - 1; target++) {
            if (target < targets.size() - 1) {
                System.out.print(targets.get(target) + "|");
            } else {
                System.out.print(targets.get(target));
            }
        }
    }

    // проверява дали индекс е пол.число и дали е в граница на масив/лист
    private static boolean isValidIndex(int index, int lastIndex) {
        //index >= 0 && index <= numbers.size() - 1
        return index >= 0 && index <= lastIndex;
    }
}