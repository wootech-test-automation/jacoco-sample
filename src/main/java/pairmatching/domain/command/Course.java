package pairmatching.domain.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.utils.ValueChecker;

public enum Course {

    BACKEND("백엔드", "/backend-crew.md"),
    FRONTEND("프론트엔드", "/frontend-crew.md");

    private static final String FILE_PATH_PREFIX = "src/main/resources";
    private static final ValueChecker valueChecker = ValueChecker.createFromRightValues(addRightValues());
    public String command;
    public String path;

    static List<String> addRightValues() {
        return Arrays.stream(Course.values())
                .map(course -> course.command)
                .collect(Collectors.toList());
    }


    public static Course of(String message) {
        valueChecker.validate(message);
        return Arrays.stream(Course.values())
                .filter(course -> course.command.equals(message))
                .findFirst()
                .get();
    }

    Course(String name, String path) {
        this.command = name;
        this.path = path;
    }

    public String getPath() {
        return FILE_PATH_PREFIX + path;
    }
}
