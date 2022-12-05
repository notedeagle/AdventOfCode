import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 extends AdventOfCode {
    public Day1(String path) {
        super(path);
    }

    @Override
    protected String runPart1(List<String> input) {
        int max = 0;
        int currentMax = 0;

        for (String calorie : input) {
            if (!calorie.isEmpty()) {
                currentMax += Integer.parseInt(calorie);
            } else {
                if (currentMax > max) {
                    max = currentMax;
                }
                currentMax = 0;
            }
        }

        return String.valueOf(max);
    }

    @Override
    protected String runPart2(List<String> input) {
        int currentMax = 0;
        List<Integer> calories = new ArrayList<>();

        for (String calorie : input) {
            if (!calorie.isEmpty()) {
                currentMax += Integer.parseInt(calorie);
            } else {
                calories.add(currentMax);
                currentMax = 0;
            }
        }

        calories.sort(Comparator.reverseOrder());
        int topThreeSum = 0;
        for (int i = 0; i < 3; i++) {
            topThreeSum += calories.get(i);
        }

        return String.valueOf(topThreeSum);
    }

    public static void main(String[] args) {
        new Day1("files/day1.txt");
    }
}