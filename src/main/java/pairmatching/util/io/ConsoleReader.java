package pairmatching.util.io;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.type.Feature;
import pairmatching.domain.type.MatchingInformation;
import pairmatching.domain.type.YesOrNo;

public class ConsoleReader {

    public static Feature readFeature() {
        String line = Console.readLine();
        return Feature.matchOf(line);
    }

    public static MatchingInformation readInformation() {
        String line = Console.readLine();
        return MatchingInformation.of(line);
    }

    public static YesOrNo readYseOrNo() {
        String line = Console.readLine();
        return YesOrNo.matchOf(line);
    }
}
