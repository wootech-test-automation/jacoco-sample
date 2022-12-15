package pairmatching.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Crew;
import pairmatching.domain.enums.Course;
import pairmatching.message.ErrorMessage;

public class CrewRepository {
    private static final CrewRepository instance = new CrewRepository();
    private static final List<Crew> store = new ArrayList<>();
    private static final String BACKEND_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_PATH = "src/main/resources/frontend-crew.md";

    static {
        initializeCrew(BACKEND_PATH, Course.BACKEND);
        initializeCrew(FRONTEND_PATH, Course.FRONTEND);
    }

    private CrewRepository() {
    }

    public static CrewRepository getInstance() {
        return instance;
    }

    private static void initializeCrew(String path, Course course) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            store.addAll(reader.lines()
                    .collect(Collectors.toList())
                    .stream()
                    .map(name -> new Crew(course, name))
                    .collect(Collectors.toList()));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(ErrorMessage.FILE_NOT_FOUND_ERROR);
        }
    }
}
