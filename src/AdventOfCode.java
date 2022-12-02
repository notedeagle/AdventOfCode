import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ERROR = "Error!";

    public static void main(String[] args) {
        System.out.println("Wybierz dzień:");
        int dayNumber = scanner.nextInt();

        switch (dayNumber) {
            case 1 -> day1();
            case 2 -> day2();
            default -> System.out.println("Brak dnia o tym numerze!");
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
                        default -> System.out.println(ERROR);
                    }
                }
                case 'B' -> { //paper, X - rock, 1, Y - paper, 2, Z - scissors, 3
                    switch (game[2]) {
                        case 'X' -> points += 1;
                        case 'Y' -> points += 5;
                        case 'Z' -> points += 9;
                        default -> System.out.println(ERROR);
                    }
                }
                case 'C' -> { //scissors, X - rock, 1, Y - paper, 2, Z - scissors, 3
                    switch (game[2]) {
                        case 'X' -> points += 2;
                        case 'Y' -> points += 6;
                        case 'Z' -> points += 7;
                        default -> System.out.println(ERROR);
                    }
                }
                default -> System.out.println(ERROR);
            }
        }

        System.out.println("Your score: " + points);
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