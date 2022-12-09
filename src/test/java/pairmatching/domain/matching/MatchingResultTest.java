package pairmatching.domain.matching;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static pairmatching.utils.TestUtils.convertStringToCrews;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pairmatching.domain.code.Course;
import pairmatching.exception.BeforeMatchedCrewException;
import pairmatching.exception.DuplicatedMatchingDivisionException;
import pairmatching.exception.MatchingDivisionDidNotExists;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchingResultTest {

    @Test
    void 중복되는_키가_있는_경우_에러를_발생시킵니다() {
        var matchingResult = new MatchingResult();
        var matchingDivision = new MatchingDivision("백엔드,레벨1,자동차경주");

        assertThatThrownBy(() -> {
            matchingResult.matchPair(matchingDivision, convertStringToCrews(Course.BACKEND, "가,나,다"));
            matchingResult.matchPair(matchingDivision, convertStringToCrews(Course.BACKEND, "가,나,다"));
        }).isInstanceOf(DuplicatedMatchingDivisionException.class);
    }

    @Test
    void 키를_통해서_매칭_결과를_조회할때_데이터가_없는_경우_에러를_발생시킵니다() {
        var matchingResult = new MatchingResult();
        var matchingDivision = new MatchingDivision("백엔드,레벨1,자동차경주");

        assertThatThrownBy(() -> {
            matchingResult.findByMatchingDivision(matchingDivision);
        }).isInstanceOf(MatchingDivisionDidNotExists.class);
    }

    @Test
    void 같은_레벨에서_페어를_맺은적이_있는_크루가_있는_경우_오류를_발생시킵니다() {
        var matchingResult = new MatchingResult();
        var matchingDivision = new MatchingDivision("백엔드,레벨1,자동차경주");

        var newMatchingDivision = new MatchingDivision("백엔드,레벨1,로또");
        assertThatThrownBy(() -> {
            matchingResult.matchPair(matchingDivision, convertStringToCrews(Course.BACKEND, "가,나,다"));

            matchingResult.matchPair(newMatchingDivision, convertStringToCrews(Course.BACKEND, "가,나,다"));
        }).isInstanceOf(BeforeMatchedCrewException.class);

    }

}