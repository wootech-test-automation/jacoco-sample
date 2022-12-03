package pairmatching.util.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.domain.type.Course;
import pairmatching.domain.type.Feature;
import pairmatching.domain.type.Level;
import pairmatching.domain.type.Mission;
import pairmatching.domain.type.YesOrNo;

public class ConsoleReader {

    private static final String COMMA = ",";

    public static Feature readFeature() {
        String line = Console.readLine();
        return Feature.matchOf(line);
    }

    public static List<Object> readInformation() {
        String line = Console.readLine();
        String[] split = line.split(COMMA);
        Course course = Course.matchOf(split[0].trim());
        Level level = Level.matchOf(split[1].trim());
        Mission mission = Mission.matchOf(split[2].trim(), level);
        return List.of(course, level, mission);
    }

    public static YesOrNo readYseOrNo() {
        String line = Console.readLine();
        return YesOrNo.matchOf(line);
    }
}
