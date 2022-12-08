package pairmatching.domain.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
    LEVEL1("레벨1", List.of(Subject.RACING, Subject.LOTTO, Subject.BASEBALL)),
    LEVEL2("레벨2", List.of(Subject.SHOPPING, Subject.PAYMENT, Subject.SUBWAY)),
    LEVEL3("레벨3"),
    LEVEL4("레벨4", List.of(Subject.IMPROVE_PERFORMANCE, Subject.DEPLOY)), LEVEL5("레벨5");

    private final String name;
    private final List<Subject> subjects;

    Level(final String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    Level(final String name, final List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public static Level from(final String name, final Subject subject) {
        return Arrays.stream(values())
                .filter(level -> level.name.equals(name.trim()))
                .filter(level -> level.subjects.contains(subject))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static String messages() {
        return Arrays.stream(values())
                .map(Level::message)
                .collect(Collectors.joining("\n"));
    }

    private String message() {
        var subjectNames = subjects.stream()
                .map(Subject::getName)
                .collect(Collectors.joining(" | "));
        return String.format("  - %s: %s", name, subjectNames);
    }
}
