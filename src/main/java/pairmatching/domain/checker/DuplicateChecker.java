package pairmatching.domain.checker;


import java.util.List;
import pairmatching.domain.type.Course;
import pairmatching.domain.type.Mission;
import pairmatching.domain.type.Pair;


public interface DuplicateChecker {

    boolean isDuplicate(Course course, Mission mission);

    boolean isDuplicatePair(String inputKey, List<Pair> pairs);
}
