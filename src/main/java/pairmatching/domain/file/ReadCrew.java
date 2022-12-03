package pairmatching.domain.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import pairmatching.domain.code.Course;

public class ReadCrew {
    private static final String RESOURCES = "src/main/resources";
    private static final String BACKEND = "/backend-crew.md";
    private static final String FRONTEND = "/frontend-crew.md";

    private final Course selectedCourse;

    public ReadCrew(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public List<String> readBackendCrew() {
        return this.findByCourse(Course.BACKEND, BACKEND);
    }

    public List<String> readFrontendCrew() {
        return this.findByCourse(Course.FRONTEND, FRONTEND);
    }

    public List<String> read() {
        if (selectedCourse.isBackend()) {
            return this.readBackendCrew();
        }
        return this.readFrontendCrew();
    }

    private List<String> findByCourse(Course course, String file) {
        try {
            return Files.readAllLines(Paths.get(RESOURCES + file));

        } catch (IOException exception) {
            throw new IllegalStateException("읽을 수 없습니다.");
        }
    }
}
