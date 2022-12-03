package pairmatching.domain.command;

import java.util.Arrays;
import pairmatching.utils.ValueChecker;

public enum FunctionCommand {
    PAIR_MATCH("1"),
    PAIR_SEARCH("2"),
    PAIR_RESET("3"),
    QUIT("Q");

    private String command;
    private static ValueChecker valueChecker =
            ValueChecker.createFromRightValues(PAIR_MATCH.command, PAIR_SEARCH.command,
                    PAIR_RESET.command, QUIT.command);

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
