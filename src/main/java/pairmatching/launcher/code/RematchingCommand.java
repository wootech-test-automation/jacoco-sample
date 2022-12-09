package pairmatching.launcher.code;

import java.util.Arrays;
import java.util.stream.Collectors;
import pairmatching.launcher.status.BeforeMatchingIgnoreProcessStatus;
import pairmatching.launcher.status.InputStatus;
import pairmatching.launcher.status.MatchingProcessStatus;
import pairmatching.launcher.status.PairmatchingStatus;

public enum RematchingCommand {
    YES("네", new InputStatus(new MatchingProcessStatus())),
    NO("아니오", new InputStatus(new BeforeMatchingIgnoreProcessStatus()));

    private final String command;
    private final PairmatchingStatus nextStatus;

    RematchingCommand(final String command, PairmatchingStatus nextStatus) {
        this.command = command;
        this.nextStatus = nextStatus;
    }

    public static RematchingCommand from(final String input) {
        return Arrays.stream(values())
                .filter(rematchingCommand -> rematchingCommand.command.equals(input.trim()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static String message() {
        return Arrays.stream(values())
                .map(rematchingCommand -> rematchingCommand.command)
                .collect(Collectors.joining(" | "));
    }

    public PairmatchingStatus getNextStatus() {
        return nextStatus;
    }
}