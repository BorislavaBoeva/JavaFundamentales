package Exercise.AssociativeArraysLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> statistic = new LinkedHashMap<>();
        Map<String, Integer> submission = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("exam finished")) {
            String[] data = input.split("-");
            String studentName = data[0];
            String language = data[1];
            if (!language.equals("banned")) {
                int points = Integer.parseInt(data[2]);
                //You should store each username and their submissions and points.
                if (!statistic.containsKey(studentName)) {
                    statistic.put(studentName, points);
                    if (!submission.containsKey(language)) {
                        submission.put(language, 1);
                    } else
                        submission.put(language, submission.get(language) + 1);
                } else {
                    // ako ключа вече е записан в мап-а ? стравнявам новите точки съв вече записаните
                    if (points >= statistic.get(studentName)) {
                        statistic.put(studentName, points);
                        // увеличавам submission
                        submission.put(language, submission.get(language) + 1);
                    } else {
                        // ако точките са по - малко увеличи submission
                        submission.put(language, submission.get(language) + 1);
                    }
                }
            } else {
                if (statistic.containsKey(studentName)) {
                    //remove the user from the contest
                    // but preserve his submissions in the total count of submissions for each language.
                   statistic.remove(studentName);
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        for (
                Map.Entry<String, Integer> entry : statistic.entrySet()) {
            String studentName = entry.getKey();
            Integer points = entry.getValue();
            System.out.printf("%s | %d\n", studentName, points);
        }
        System.out.println("Submissions:");
        for (
                Map.Entry<String, Integer> entry : submission.entrySet()) {
            String language = entry.getKey();
            Integer submissionCount = entry.getValue();
            System.out.printf("%s - %d\n", language, submissionCount);
        }
    }
}