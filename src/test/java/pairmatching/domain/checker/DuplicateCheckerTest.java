package pairmatching.domain.checker;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import pairmatching.db.Database;
import pairmatching.domain.maker.OddPairMaker;
import pairmatching.domain.type.Crew;
import pairmatching.domain.type.Level;
import pairmatching.domain.type.MatchingInformation;
import pairmatching.domain.type.Pair;
import pairmatching.exception.DuplicatePairException;

class DuplicateCheckerTest {

    private final Database database = new Database();
    private final DuplicateChecker duplicateChecker = new DefaultDuplicateChecker(database);


    @Test
    void test() {
        // given
        database.addAll(MatchingInformation.of("백엔드, 레벨1, 자동차경주"), makeExistPairs());

        // expect
        assertThatThrownBy(
                () -> duplicateChecker.checkDuplicatePair(Level.LEVEL1.toString(), makeInputPairs()))
                .isInstanceOf(DuplicatePairException.class);
    }

    private List<Pair> makeInputPairs() {
        return makePairs("현규", "현석", "현자", "현빈", "현상", "현종", "빈석");
    }

    private List<Pair> makeExistPairs() {
        return makePairs("현규", "현승", "현자", "현석", "현빈", "현상", "현종");
    }

    private List<Pair> makePairs(String... names) {
        List<Crew> crews = Stream.of(names)
                .map(Crew::makeBackendCrew)
                .collect(Collectors.toList());
        return new OddPairMaker().createPair(crews);
    }
}