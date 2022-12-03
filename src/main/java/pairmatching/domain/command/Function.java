package pairmatching.domain.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.utils.ValueChecker;

public enum Function {
    PAIR_MATCH("1"),
    PAIR_SEARCH("2"),
    PAIR_RESET("3"),
    QUIT("Q");

    private static final ValueChecker valueChecker = ValueChecker.createFromRightValues(addRightValues());
    public String command;

    static List<String> addRightValues() {
        return Arrays.stream(Function.values())
                .map(function -> function.command)
                .collect(Collectors.toList());
    }

    public static Function of(String message) {
        valueChecker.validate(message);
        return Arrays.stream(Function.values())
                .filter(function -> function.command.equals(message))
                .findFirst()
                .get();
    }

    Function(String command) {
        this.command = command;
    }
}
