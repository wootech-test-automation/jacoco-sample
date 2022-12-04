package pairmatching.domain.code;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum RetryCommand implements InputCommand {
    YES("네", true),
    NO("아니오", false);
    
    private final String command;
    private final boolean retryAble;

    RetryCommand(final String input, final boolean retryAble) {
        this.command = input;
        this.retryAble = retryAble;
    }

    public static RetryCommand of(final String input) {
        return Arrays.stream(values())
                .filter(retryCommand -> retryCommand.command.equals(input.trim()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE, input)));
    }

    public static String message() {
        return Arrays.stream(values()).map(retryCommand -> retryCommand.command)
                .collect(Collectors.joining(" | "));
    }

    public boolean isRetry() {
        return retryAble;
    }
}
