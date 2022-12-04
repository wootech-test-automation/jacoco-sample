package pairmatching.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {
    private static final String RESOURCES = "src/main/resources/";

    public static List<String> readFileByCourse(String path) {
        try {
            return Files.readAllLines(Paths.get(RESOURCES, path));
        } catch (IOException exception) {
            throw new IllegalStateException("파일을 읽을 수 없습니다.");
        }
    }

}
