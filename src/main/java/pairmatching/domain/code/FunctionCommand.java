package pairmatching.domain.code;

import java.util.Arrays;

public enum FunctionCommand {
    PAIRMATCHING("1", "페어 매칭"),
    PAIR_SEARCHING("2", "페어 조회"),
    PAIR_INITIALIZING("3", "페어 초기화"),
    QUIT("Q", "종료");

    public static final String DID_NOT_EXISTS_COMMAND = "존재하지 않는 명령어입니다";
    private static final String ERROR_MESSAGE = DID_NOT_EXISTS_COMMAND + "[input : %s]";
    private final String command;
    private final String message;

    FunctionCommand(String command, String message) {
        this.command = command;
        this.message = message;
    }

    public static FunctionCommand of(String input) {
        return Arrays.stream(values())
                .filter(functionCommand -> functionCommand.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
    }

    public boolean isMatching() {
        return this == PAIRMATCHING;
    }

    public boolean isSearch() {
        return this == PAIR_SEARCHING;
    }

    public boolean isReset() {
        return this == PAIR_INITIALIZING;
    }
}
