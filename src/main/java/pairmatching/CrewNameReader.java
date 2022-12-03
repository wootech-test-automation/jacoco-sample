package pairmatching;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrewNameReader {

    private static final String BACKEND = "백엔드";
    private static final String FRONTEND = "프론트엔드";
    private static final String FILE_PATH_PREFIX = "src/main/resources";
    private static final String BACKEND_PATH = "/backend-crew.md";
    private static final String FRONTEND_PATH = "/frontend-crew.md";
    private File crewNameFile;

    public List<String> readCrewNames(String course) throws IOException {
        if (course.equals(BACKEND)) {
            crewNameFile = new File(FILE_PATH_PREFIX + BACKEND_PATH);
        }

        if (course.equals(FRONTEND)) {
            crewNameFile = new File(FILE_PATH_PREFIX + FRONTEND_PATH);
        }

        Scanner scanner = new Scanner(crewNameFile);
        List<String> crewNames = new ArrayList<>();
        while (scanner.hasNextLine()) {
            crewNames.add(scanner.nextLine());
        }
        return crewNames;
    }
}
