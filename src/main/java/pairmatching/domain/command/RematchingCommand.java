package pairmatching.domain.command;

import java.util.Arrays;
import pairmatching.utils.ValueChecker;

public enum RematchingCommand {

    REMATCH("네"),
    CANCEL("아니오");

    private String command;

    private static ValueChecker valueChecker = ValueChecker.createFromRightValues(REMATCH.command, CANCEL.command);

    public static RematchingCommand of(String message) {
        valueChecker.validate(message);
        return Arrays.stream(RematchingCommand.values())
                .filter(rematchingCommand -> rematchingCommand.command.equals(message))
                .findFirst()
                .get();
    }

    RematchingCommand(String command) {
        this.command = command;
    }
}
