package pairmatching.domain;

import pairmatching.util.JavaFileReader;

import java.util.List;

public class ReadCrewFile {
    private static final String RESOURCE_PATH = "src/main/resources/";
    private static final String BACKEND_PATH = RESOURCE_PATH + "backend-crew.md";
    private static final String FRONTEND_PATH = RESOURCE_PATH + "frontend-crew.md";

    public static List<String> readBackendCrew() {
        return JavaFileReader.getLinesFromFile(BACKEND_PATH);
    }

    public static List<String> readFrontendCrew() {
        return JavaFileReader.getLinesFromFile(FRONTEND_PATH);
    }
}
