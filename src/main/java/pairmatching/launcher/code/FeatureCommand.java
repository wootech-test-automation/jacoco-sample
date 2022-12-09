package pairmatching.launcher.code;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum FeatureCommand {
    MATCHING("1", "페어 매칭"),
    FIND("2", "페어 조회"),
    INITIALIZE("3", "페어 초기화"),
    QUIT("Q", "종료");


    private static final String MESSAGE_FORMAT = "%s. %s";
    private final String command;
    private final String message;

    FeatureCommand(final String command, final String message) {
        this.command = command;
        this.message = message;
    }

    public static FeatureCommand from(String input) {
        return Arrays.stream(values())
                .filter(featureCommand -> featureCommand.command.equals(input)).findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static String messages() {
        return Arrays.stream(values())
                .map(featureCommand -> String.format(MESSAGE_FORMAT, featureCommand.command, featureCommand.message))
                .collect(Collectors.joining("\n"));
    }
}
