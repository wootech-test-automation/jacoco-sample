package pairmatching.launcher.code;

import java.util.Arrays;

public enum FeatureCommand {
    MATCHING("1"),
    FIND("2"),
    INITIALIZE("3"),
    QUIT("Q");

    private final String command;

    FeatureCommand(final String command) {
        this.command = command;
    }

    public static FeatureCommand from(String input) {
        return Arrays.stream(values())
                .filter(featureCommand -> featureCommand.command.equals(input)).findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
