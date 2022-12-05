import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class AdventOfCode {
    protected AdventOfCode(String path) {
        final List<String> input = readFile(path);

        final String output1 = runPart1(input);
        final String output2 = runPart2(input);

        System.out.println("Answer to part 1: " + output1);
        System.out.println("Answer to part 2: " + output2);
    }

    protected final String ERROR = "Error!";

    protected abstract String runPart1(List<String> input);

    protected abstract String runPart2(List<String> input);

    private List<String> readFile(String filePath) {
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
