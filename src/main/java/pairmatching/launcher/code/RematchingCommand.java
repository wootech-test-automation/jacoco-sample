package pairmatching.launcher.code;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum RematchingCommand {
    YES("네"), NO("아니오");

    private final String command;

    RematchingCommand(final String command) {
        this.command = command;
    }

    public static RematchingCommand from(final String input) {
        return Arrays.stream(values())
                .filter(rematchingCommand -> rematchingCommand.command.equals(input.trim()))
                .findAny().orElseThrow(IllegalArgumentException::new);
    }

    public static String message() {
        return Arrays.stream(values())
                .map(rematchingCommand -> rematchingCommand.command)
                .collect(Collectors.joining(" | "));
    }

    public boolean isRematching() {
        return this == YES;
    }
}