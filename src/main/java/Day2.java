import java.util.List;

public class Day2 extends AdventOfCode {

    protected Day2(String path) {
        super(path);
    }

    @Override
    protected String runPart1(List<String> input) {
        return "";
    }

    @Override
    protected String runPart2(List<String> input) {
        int points = 0;

        for (String line : input) {
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
        return String.valueOf(points);
    }

    public static void main(String[] args) {
        new Day2("files/day2.txt");
    }
}
