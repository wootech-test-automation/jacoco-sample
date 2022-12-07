package pairmatching.domain.type;

import java.util.Arrays;
import java.util.Objects;

public enum Command {
    MATCHING("1"),
    SELECT("2"),
    RESET("3"),
    QUIT("Q");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static Command of(String command) {
        return Arrays.stream(Command.values())
                .filter(c -> Objects.equals(c.getCommand(), command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 커맨드가 없습니다. " + command));
    }

    private String getCommand() {
        return command;
    }
}
