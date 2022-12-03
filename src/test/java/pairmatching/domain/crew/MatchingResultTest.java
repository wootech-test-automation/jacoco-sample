package pairmatching.domain.crew;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pairmatching.domain.info.PairMatchingSelector;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchingResultTest {

    @Test
    void 매칭테스트() {
        var matchingResult = new MatchingResult();
        matchingResult.addMatching(new PairMatchingSelector("백엔드, 레벨1, 자동차경주"));
    }
}