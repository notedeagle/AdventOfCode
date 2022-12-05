import java.util.*;

public class Day5 extends AdventOfCode {
    public Day5(String path) {
        super(path);
    }

    private List<Stack<Character>> buildInitialStacks(final List<String> input) {
        final List<Stack<Character>> stacks = getStackList(input);
        final List<String> boxes = new ArrayList<>();

        for (String line : input) {
            if (line.trim().startsWith("[")) {
                boxes.add(line);
            }
        }

        Collections.reverse(boxes);

        for (String line : boxes) {
            for (int boxId = 1, stackId = 0; boxId < line.length(); boxId += 4, stackId++) {
                final char crate = line.charAt(boxId);
                if (!Character.isSpaceChar(crate)) {
                    stacks.get(stackId).push(crate);
                }
            }
        }
        return stacks;
    }

    private List<Stack<Character>> getStackList(final List<String> input) {
        final int nrOfStacks = getNrOfStacks(input);
        final List<Stack<Character>> stacks = new ArrayList<>();
        for (int i = 0; i < nrOfStacks; i++) {
            stacks.add(new Stack<>());
        }
        return stacks;
    }

    private int getNrOfStacks(final List<String> input) {
        for (String line : input) {
            if (!line.contains("[")) {
                line = line.trim();
                return Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));
            }
        }
        throw new IllegalArgumentException("Can not find number of stacks in input");
    }

    private void moveSingleCrate(final List<Stack<Character>> stacks, final int nr, int from, int to) {
        final Stack<Character> fromStack = stacks.get(--from);
        final Stack<Character> toStack = stacks.get(--to);
        for (int i = 0; i < nr; i++) {
            toStack.push(fromStack.pop());
        }
    }

    private void moveMultipleCrates(final List<Stack<Character>> stacks, final int nr, int from, int to) {
        final Stack<Character> fromStack = stacks.get(--from);
        final Stack<Character> toStack = stacks.get(--to);
        final StringBuilder cratesToMove = new StringBuilder();
        for (int i = 0; i < nr; i++) {
            cratesToMove.insert(0, fromStack.pop());
        }
        cratesToMove.chars().forEach(c -> toStack.push((char) c));
    }

    private String getTopCrates(final List<Stack<Character>> stacks) {
        final StringBuilder sb = new StringBuilder();
        stacks.forEach(s -> sb.append(s.peek()));
        return sb.toString();
    }

    private void run(List<Stack<Character>> stacks, List<String> input, boolean part2) {
        for (final String line : input) {
            if (line.startsWith("move")) {
                String[] l = line.split(" ");
                final int nr = Integer.parseInt(l[1]);
                final int from = Integer.parseInt(l[3]);
                final int to = Integer.parseInt(l[5]);
                if (!part2) {
                    moveSingleCrate(stacks, nr, from, to);
                } else {
                    moveMultipleCrates(stacks, nr, from, to);
                }
            }
        }
    }

    @Override
    protected String runPart1(List<String> input) {
        List<Stack<Character>> stacks = buildInitialStacks(input);
        run(stacks, input, false);
        return getTopCrates(stacks);
    }

    @Override
    protected String runPart2(List<String> input) {
        List<Stack<Character>> stacks = buildInitialStacks(input);
        run(stacks, input, true);
        return getTopCrates(stacks);
    }

    public static void main(String[] args) {
        new Day5("files/day5.txt");
    }
}
