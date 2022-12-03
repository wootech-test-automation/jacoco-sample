package pairmatching.domain.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.utils.ValueChecker;

public enum CourseCommand {

    BACKEND("백엔드", "/backend-crew.md"),
    FRONTEND("프론트엔드", "/frontend-crew.md");

    private static final String FILE_PATH_PREFIX = "src/main/resources";
    private static final ValueChecker valueChecker = ValueChecker.createFromRightValues(addRightValues());
    public String command;
    public String path;

    static List<String> addRightValues() {
        return Arrays.stream(CourseCommand.values())
                .map(command -> command.command)
                .collect(Collectors.toList());
    }


    public static CourseCommand of(String message) {
        valueChecker.validate(message);
        return Arrays.stream(CourseCommand.values())
                .filter(courseCommand -> courseCommand.command.equals(message))
                .findFirst()
                .get();
    }

    CourseCommand(String name, String path) {
        this.command = name;
        this.path = path;
    }

    public String getPath() {
        return FILE_PATH_PREFIX + path;
    }
}
