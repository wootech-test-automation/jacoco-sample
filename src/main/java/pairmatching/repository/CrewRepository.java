package pairmatching.repository;

import pairmatching.domain.ReadCrewFile;
import pairmatching.domain.type.Course;

import java.util.List;

public class CrewRepository {
    List<String> backendCrew;
    List<String> frontendCrew;

    public CrewRepository() {
        backendCrew = ReadCrewFile.readBackendCrew();
        frontendCrew = ReadCrewFile.readFrontendCrew();
    }

    public List<String> getCrew(Course course) {
        if (course.isBackend()) {
            return backendCrew;
        }
        return frontendCrew;
    }
}
