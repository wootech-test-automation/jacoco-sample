package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.type.Command;
import pairmatching.domain.type.CourseLevelMission;
import pairmatching.domain.type.Rematching;

public class InputView {
    public static Command readCommand() {
        String input = Console.readLine();
        return Command.of(input);
    }

    public static CourseLevelMission readCourseLevelMission() {
        String input = Console.readLine();
        return new CourseLevelMission(input);
    }

    public static boolean readRematching() {
        String input = Console.readLine();
        return Rematching.wordIsYes(input);
    }
}
