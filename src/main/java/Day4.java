import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Day4 extends AdventOfCode {
    public Day4(String path) {
        super(path);
    }

    @Override
    protected String runPart1(List<String> input) {
        String[] parts;
        int sum = 0;

        for (String line : input) {
            parts = line.split(",");
            String[] range1 = parts[0].split("-");
            String[] range2 = parts[1].split("-");
            List<Integer> numbers1 = IntStream.range(Integer.parseInt(range1[0]), Integer.parseInt(range1[1]) + 1)
                    .boxed()
                    .toList();
            List<Integer> numbers2 = IntStream.range(Integer.parseInt(range2[0]), Integer.parseInt(range2[1]) + 1)
                    .boxed()
                    .toList();

            if (new HashSet<>(numbers1).containsAll(numbers2) || new HashSet<>(numbers2).containsAll(numbers1)) {
                sum++;
            }
        }

        return String.valueOf(sum);
    }

    @Override
    protected String runPart2(List<String> input) {
        String[] parts;
        int sum = 0;

        for (String line : input) {
            parts = line.split(",");
            String[] range1 = parts[0].split("-");
            String[] range2 = parts[1].split("-");
            List<Integer> numbers1 = IntStream.range(Integer.parseInt(range1[0]), Integer.parseInt(range1[1]) + 1)
                    .boxed()
                    .toList();
            List<Integer> numbers2 = IntStream.range(Integer.parseInt(range2[0]), Integer.parseInt(range2[1]) + 1)
                    .boxed()
                    .toList();

            if (!Collections.disjoint(numbers1, numbers2)) {
                sum++;
            }
        }

        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        new Day4("files/day4.txt");
    }
}
