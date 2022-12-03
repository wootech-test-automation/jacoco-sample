package pairmatching.domain.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.utils.ValueChecker;

public enum RematchingCommand {

    REMATCH("네"),
    CANCEL("아니오");

    private static final ValueChecker valueChecker = ValueChecker.createFromRightValues(addRightValues());
    public String command;

    static List<String> addRightValues() {
        return Arrays.stream(RematchingCommand.values())
                .map(command -> command.command)
                .collect(Collectors.toList());
    }


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
