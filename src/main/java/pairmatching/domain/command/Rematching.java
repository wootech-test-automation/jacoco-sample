package pairmatching.domain.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.utils.ValueChecker;

public enum Rematching {

    REMATCH("네"),
    CANCEL("아니오");

    private static final ValueChecker valueChecker = ValueChecker.createFromRightValues(addRightValues());
    public String command;

    static List<String> addRightValues() {
        return Arrays.stream(Rematching.values())
                .map(command -> command.command)
                .collect(Collectors.toList());
    }


    public static Rematching of(String message) {
        valueChecker.validate(message);
        return Arrays.stream(Rematching.values())
                .filter(rematching -> rematching.command.equals(message))
                .findFirst()
                .get();
    }

    Rematching(String command) {
        this.command = command;
    }

}
