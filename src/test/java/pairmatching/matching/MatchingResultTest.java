package pairmatching.matching;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pairmatching.domain.matching.MatchingDivision;
import pairmatching.domain.matching.MatchingResult;
import pairmatching.utils.TestUtils;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchingResultTest {

    @Test
    void 이전에_매칭된_경력이_있으면_오류를_발생시킵니다() {
        var matchingResult = new MatchingResult();
        matchingResult.matchPair(new MatchingDivision("백엔드, 레벨1, 자동차경주"), List.of());
        assertThatIllegalStateException()
                .isThrownBy(() -> matchingResult.matchPair(new MatchingDivision("백엔드, 레벨1, 자동차경주"), List.of()));
    }


    @Test
    void 같은_레벨에서_매칭된_경험이_있으면_오류를_발생시킵니다() {
        var matchingResult = new MatchingResult();
        matchingResult.matchPair(new MatchingDivision("백엔드, 레벨1, 자동차경주"), TestUtils.stringToCrews("크루,크루1,크루2"));
        assertThatIllegalStateException()
                .isThrownBy(() -> matchingResult.matchPair(new MatchingDivision("백엔드, 레벨1, 로또"),
                        TestUtils.stringToCrews("크루,크루1,크루2")));
    }

}