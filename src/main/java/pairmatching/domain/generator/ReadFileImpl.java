package pairmatching.domain.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileImpl implements ReadFile {
    private static final String RESOURCES = "src/main/resources/";

    @Override
    public List<String> readFile(String fileName) {
        return this.read(fileName);
    }

    private List<String> read(String fileName) {
        try {
            return Files.readAllLines(Paths.get(RESOURCES + fileName));
        } catch (IOException exception) {
            throw new IllegalStateException();
        }
    }
}
