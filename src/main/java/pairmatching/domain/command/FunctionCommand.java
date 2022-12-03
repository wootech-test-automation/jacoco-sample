package pairmatching.domain.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.utils.ValueChecker;

public enum FunctionCommand {
    PAIR_MATCH("1"),
    PAIR_SEARCH("2"),
    PAIR_RESET("3"),
    QUIT("Q");

    private static final ValueChecker valueChecker = ValueChecker.createFromRightValues(addRightValues());
    public String command;

    static List<String> addRightValues() {
        return Arrays.stream(FunctionCommand.values())
                .map(command -> command.command)
                .collect(Collectors.toList());
    }

    public static FunctionCommand of(String message) {
        valueChecker.validate(message);
        return Arrays.stream(FunctionCommand.values())
                .filter(functionCommand -> functionCommand.command.equals(message))
                .findFirst()
                .get();
    }

    FunctionCommand(String command) {
        this.command = command;
    }
}
