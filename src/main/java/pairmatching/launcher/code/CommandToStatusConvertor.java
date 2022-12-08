package pairmatching.launcher.code;

import java.util.Arrays;

import pairmatching.launcher.status.InputStatus;
import pairmatching.launcher.status.PairmatchingStatus;
import pairmatching.launcher.status.QuitStatus;

public enum CommandToStatusConvertor {
    MATCHING(FeatureCommand.MATCHING, new InputStatus()),
    FIND(FeatureCommand.FIND),
    INITIALIZE(FeatureCommand.INITIALIZE),
    QUIT(FeatureCommand.QUIT),
    UNKNOWN();


    private final FeatureCommand command;
    private final PairmatchingStatus status;

    CommandToStatusConvertor(FeatureCommand command, PairmatchingStatus status) {
        this.command = command;
        this.status = status;
    }

    CommandToStatusConvertor(FeatureCommand command) {
        this.command = command;
        this.status = new QuitStatus();
    }

    CommandToStatusConvertor() {
        this.command = null;
        this.status = new QuitStatus();
    }

    public static PairmatchingStatus getNextStatus(FeatureCommand featureCommand) {
        return Arrays.stream(values())
                .filter(convertor -> convertor.command.equals(featureCommand))
                .findAny()
                .orElse(UNKNOWN)
                .status;
    }
}
