import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode {
    private static final Scanner scanner = new Scanner(System.in);

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
        String filePath = "files/Elfy.txt";
        String line;
        int max = 0;
        int currentMax = 0;
        List<Integer> calories = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")) {
                    currentMax += Integer.parseInt(line);
                } else {
                    if (currentMax > max) {
                        max = currentMax;
                    }
                    calories.add(currentMax);
                    currentMax = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    }
}