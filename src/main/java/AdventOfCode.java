import com.google.common.collect.Lists;
import org.checkerframework.checker.units.qual.A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class AdventOfCode {
    private static final String ERROR = "Error!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose day:");
        int dayNumber = scanner.nextInt();

        switch (dayNumber) {
            case 1 -> day1();
            case 2 -> day2();
            case 3 -> day3();
            default -> System.err.println(ERROR);
        }
    }

    public static void day1() {
        String filePath = "files/day1.txt";
        int max = 0;
        int currentMax = 0;
        List<String> lines = readFile(filePath);
        List<Integer> calories = new ArrayList<>();


        for (String calorie : lines) {
            if (!calorie.isEmpty()) {
                currentMax += Integer.parseInt(calorie);
            } else {
                if (currentMax > max) {
                    max = currentMax;
                }
                calories.add(currentMax);
                currentMax = 0;
            }
        }

        calories.sort(Comparator.reverseOrder());
        int topThreeSum = 0;
        for (int i = 0; i < 3; i++) {
            topThreeSum += calories.get(i);
        }

        System.out.println("Max: " + max);
        System.out.println("Top three sum: " + topThreeSum);
    }

    public static void day2() {
        String filePath = "files/day2.txt";
        List<String> lines = readFile(filePath);
        int points = 0;

        for (String line : lines) {
            char[] game = line.toCharArray();

            switch (game[0]) { //win - 6, draw - 3, lost - 0
                case 'A' -> {
                    switch (game[2]) {
                        case 'X' -> points += 3;
                        case 'Y' -> points += 4;
                        case 'Z' -> points += 8;
                        default -> System.err.println(ERROR);
                    }
                }
                case 'B' -> { //paper, X - rock, 1, Y - paper, 2, Z - scissors, 3
                    switch (game[2]) {
                        case 'X' -> points += 1;
                        case 'Y' -> points += 5;
                        case 'Z' -> points += 9;
                        default -> System.err.println(ERROR);
                    }
                }
                case 'C' -> { //scissors, X - rock, 1, Y - paper, 2, Z - scissors, 3
                    switch (game[2]) {
                        case 'X' -> points += 2;
                        case 'Y' -> points += 6;
                        case 'Z' -> points += 7;
                        default -> System.err.println(ERROR);
                    }
                }
                default -> System.err.println(ERROR);
            }
        }

        System.out.println("Your score: " + points);
    }

    public static void day3() {
        String filePath = "files/day3.txt";
        List<String> lines = readFile(filePath);
        int sum = 0;

        for (String line : lines) {
            int length = line.length();
            String part1 = line.substring(0, length / 2);
            String part2 = line.substring(length / 2);
            char[] part2Chars = part2.toCharArray();

            for (char letter : part2Chars) {
                if (part1.contains(String.valueOf(letter))) {
                    if (Character.isUpperCase(letter)) {
                        sum += letter - 38;
                    } else {
                        sum += letter - 96;
                    }
                    break;
                }
            }
        }

        System.out.println("Wynik zadania 1: " + sum);

        sum = 0;
        List<List<String>> lists = Lists.partition(lines, 3);

        for (List<String> list : lists) {
            String a = list.get(0);
            String b = list.get(1);
            String c = list.get(2);
            char[] d = b.toCharArray();

            for (char letter : d) {
                if (a.contains(String.valueOf(letter)) && c.contains(String.valueOf(letter))) {
                    if (Character.isUpperCase(letter)) {
                        sum += letter - 38;
                    } else {
                        sum += letter - 96;
                    }
                    break;
                }
            }
        }

        System.out.println("Wynik zadania 2: " + sum);
    }

    public static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}