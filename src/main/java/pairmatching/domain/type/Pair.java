package pairmatching.domain.type;

import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    private final CourseLevelMission courseLevelMission;
    private final List<String> crew;

    public Pair(CourseLevelMission courseLevelMission, List<String> crew) {
        this.courseLevelMission = courseLevelMission;
        this.crew = List.copyOf(crew);
    }

    public boolean isSameCrew(Pair pair) {
        if (crew.size() != pair.getCrew().size()) {
            return false;
        }
        if (!crew.containsAll(pair.getCrew())) {
            return false;
        }
        return true;
    }

    public boolean isSameCourse(Course course) {
        return courseLevelMission.getCourse() == course;
    }

    public boolean isSameLevel(Level level) {
        return courseLevelMission.getLevel() == level;
    }

    public boolean isSameLevel(Pair pair) {
        return courseLevelMission.getLevel() == pair.getCourseLevelMission().getLevel();
    }

    public boolean isSameMission(Mission mission) {
        return courseLevelMission.getMission() == mission;
    }

    public boolean isSameMission(Pair pair) {
        return courseLevelMission.getMission() == pair.getCourseLevelMission().getMission();
    }

    private CourseLevelMission getCourseLevelMission() {
        return courseLevelMission;
    }

    private List<String> getCrew() {
        return crew;
    }

    @Override
    public String toString() {
        return String.join(" : ", crew);
    }
}
