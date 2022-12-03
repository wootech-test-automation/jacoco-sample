package pairmatching.domain.command;

import java.util.Arrays;
import pairmatching.utils.ValueChecker;

public enum CourseCommand {

    BACKEND("백엔드", "/backend-crew.md"),
    FRONTEND("프론트엔드", "/frontend-crew.md");

    private static final String FILE_PATH_PREFIX = "src/main/resources";
    private String command;
    private String path;
    private static ValueChecker valueChecker = ValueChecker.createFromRightValues(BACKEND.command,FRONTEND.command);

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
