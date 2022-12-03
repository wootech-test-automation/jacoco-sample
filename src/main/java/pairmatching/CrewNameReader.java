package pairmatching;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pairmatching.domain.Course;

public class CrewNameReader {

    public List<String> readCrewNames(Course course) throws IOException {
        File crewNameFile = new File(course.getPath());
        Scanner scanner = new Scanner(crewNameFile);

        List<String> crewNames = new ArrayList<>();
        while (scanner.hasNextLine()) {
            crewNames.add(scanner.nextLine());
        }
        return crewNames;
    }
}
