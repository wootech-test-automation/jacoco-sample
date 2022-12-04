package pairmatching.domain.code;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum FeaturesCommandCode implements InputCommand {
    MATCHING("1", "페어 매칭"),
    SELECT("2", "페어 조회"),
    INITIALIZE("3", "페어 초기화"),
    QUIT("Q", "종료");

    private static final String MESSAGE_FORMAT = "%s. %s";
    private final String command;
    private final String message;

    FeaturesCommandCode(String command, String message) {
        this.command = command;
        this.message = message;
    }

    public static FeaturesCommandCode of(final String input) {
        return Arrays.stream(values())
                .filter(featuresCommandCode -> featuresCommandCode.command.equals(input.trim()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE, input)));
    }

    public static String getMessages() {
        return Arrays.stream(values())
                .map(FeaturesCommandCode::getMessage)
                .collect(Collectors.joining("\n"));
    }

    private String getMessage() {
        return String.format(MESSAGE_FORMAT, command, message);
    }

    public boolean isMatching() {
        return this == MATCHING;
    }
}
