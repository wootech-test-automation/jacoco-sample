package pairmatching.domain.code;

import java.util.Arrays;

public enum RematchingCommand {
    YES("네"),
    NO("아니오");

    public static final String DID_NOT_EXISTS_MATCHING_COMMAND = "해당 명령어는 존재하지 않습니다";
    private final String rematchingCommand;

    RematchingCommand(String rematchingCommand) {
        this.rematchingCommand = rematchingCommand;
    }

    public static RematchingCommand of(String input) {
        var findCommand = input.trim();
        return Arrays.stream(RematchingCommand.values())
                .filter(command -> command.rematchingCommand.equals(findCommand))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(DID_NOT_EXISTS_MATCHING_COMMAND));
    }

    public boolean isRetry() {
        return this == YES;
    }
}
