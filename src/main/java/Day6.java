import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 extends AdventOfCode {

    public Day6(String path) {
        super(path);
    }

    private String run(String line, int characters) {
        for (int i = 0; i < line.length() - characters; i++) {
            Set<Character> letters = new HashSet<>();
            for (int j = i; j < i + characters; j++) {
                letters.add(line.charAt(j));
            }

            if (letters.size() == characters) {
                return String.valueOf(characters + i);
            }
        }

        return ERROR;
    }

    @Override
    protected String runPart1(List<String> input) {
        return run(input.get(0), 4);
    }

    @Override
    protected String runPart2(List<String> input) {
        return run(input.get(0), 14);
    }

    public static void main(String[] args) {
        new Day6("files/day6.txt");
    }
}
