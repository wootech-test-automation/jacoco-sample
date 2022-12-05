package pairmatching.domain.checker;


import java.util.List;
import pairmatching.domain.type.MatchingInformation;
import pairmatching.domain.type.Pair;


public interface DuplicateChecker {

    void checkDuplicate(MatchingInformation matchingInformation);

    void checkDuplicatePair(String inputKey, List<Pair> pairs);
}
