package pairmatching.domain.maker;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import pairmatching.domain.type.Crew;
import pairmatching.domain.type.Pair;

class PairMakerTest {

    @Test
    void shouldReturnFinalPairLengthIs3WhenCrewsSizeAreOdd() {
        //given
        List<Crew> crews = Stream.of("현승", "현규", "현자").map(Crew::makeBackendCrew).collect(Collectors.toList());
        PairMaker pairMaker = new OddPairMaker();

        // when
        List<Pair> result = pairMaker.createPair(crews);

        // then
        Pair lastPair = result.get(result.size() - 1);
        assertThat(lastPair.getThird()).isNotNull();
    }

    @Test
    void shouldReturnDoublePairWhenCrewsSizeIsEven() {
        //given
        List<Crew> crews = Stream.of("현승", "현규", "현자", "현식").map(Crew::makeBackendCrew).collect(Collectors.toList());
        PairMaker pairMaker = new EvenPairMaker();

        // when
        List<Pair> result = pairMaker.createPair(crews);

        // then
        result.forEach((pair -> {
            assertThat(pair.getFirst()).isNotNull();
            assertThat(pair.getSecond()).isNotNull();
        }));
    }
}