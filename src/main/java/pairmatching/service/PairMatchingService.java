package pairmatching.service;

import java.util.List;
import pairmatching.domain.CourseInformation;
import pairmatching.domain.Crews;
import pairmatching.domain.Pair;
import pairmatching.exception.PairAlreadyExistException;
import pairmatching.message.ErrorMessage;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MatchingCrewRepository;
import pairmatching.util.ShuffleUtil;

public class PairMatchingService {
    public static final int MAX_TRY = 3;
    private final MatchingCrewRepository matchingCrewRepository = MatchingCrewRepository.getInstance();

    public void retryPairMatching(final List<String> inputInformation) {
        CourseInformation courseInformation = CourseInformation.of(inputInformation);
        matchCrew(courseInformation, 0);
    }

    public List<Pair> pairMatch(final List<String> inputInformation) {
        CourseInformation courseInformation = validateAlreadyMatch(CourseInformation.of(inputInformation));
        return matchCrew(courseInformation, 0);
    }

    private List<Pair> matchCrew(final CourseInformation courseInformation, final int matchTryCount) {
        checkTryCount(matchTryCount);
        Crews shuffledCrews = ShuffleUtil.ShuffleCrews(CrewRepository.findAllByCourse(courseInformation.getCourse()));
        List<Pair> pairs = shuffledCrews.makePairList();
        if (hasSamePairInList(pairs)) {
            matchCrew(courseInformation, matchTryCount + 1);
        }
        matchingCrewRepository.savePairMatching(courseInformation, pairs);
        return pairs;
    }

    private boolean hasSamePairInList(final List<Pair> pairs) {
        return false;
    }

    private void checkTryCount(final int matchTryCount) {
        if (matchTryCount == MAX_TRY) {
            throw new IllegalArgumentException(ErrorMessage.LIMIT_PAIR_MATCH_TRY_ERROR);
        }
    }

    private CourseInformation validateAlreadyMatch(final CourseInformation courseInformation) {
        if (matchingCrewRepository.hasMatchedBefore(courseInformation)) {
            throw new PairAlreadyExistException();
        }
        return courseInformation;
    }
}
