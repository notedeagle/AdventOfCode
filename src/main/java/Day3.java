import com.google.common.collect.Lists;

import java.util.List;

public class Day3 extends AdventOfCode {
    public Day3(String path) {
        super(path);
    }

    @Override
    protected String runPart1(List<String> input) {
        int sum = 0;

        for (String line : input) {
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
        return String.valueOf(sum);
    }

    @Override
    protected String runPart2(List<String> input) {
        List<List<String>> lists = Lists.partition(input, 3);
        int sum = 0;

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
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        new Day3("files/day3.txt");
    }
}
