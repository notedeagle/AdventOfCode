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
            List<Integer> numbers1 = getNumbers(parts, 0);
            List<Integer> numbers2 = getNumbers(parts, 1);

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
            List<Integer> numbers1 = getNumbers(parts, 0);
            List<Integer> numbers2 = getNumbers(parts, 1);

            if (!Collections.disjoint(numbers1, numbers2)) {
                sum++;
            }
        }

        return String.valueOf(sum);
    }

    private List<Integer> getNumbers(String[] parts, int part) {
        String[] range = parts[part].split("-");
        return IntStream.range(Integer.parseInt(range[0]), Integer.parseInt(range[1]) + 1)
                .boxed()
                .toList();
    }

    public static void main(String[] args) {
        new Day4("files/day4.txt");
    }
}
