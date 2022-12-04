package pairmatching.code;

import java.util.Arrays;

public enum FeaturesCommandCode {
    MATCHING("1", "페어 매칭"),
    SELECT("2", "페어 조회"),
    INITIALIZE("3", "페어 초기화"),
    QUIT("Q", "종료");

    public static final String DID_NOT_EXISTS_CODE_NAME = "해당 명령어는 존재하지 않습니다";
    private static final String ERROR_MESSAGE = DID_NOT_EXISTS_CODE_NAME + "[input : %s]";
    private final String command;
    private final String message;

    FeaturesCommandCode(String command, String message) {
        this.command = command;
        this.message = message;
    }

    public static FeaturesCommandCode of(String input) {
        return Arrays.stream(values())
                .filter(featuresCommandCode -> featuresCommandCode.command.equals(input.trim()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE, input)));
    }
}
