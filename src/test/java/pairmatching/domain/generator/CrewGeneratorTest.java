package pairmatching.domain.generator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pairmatching.domain.code.Course;
import pairmatching.domain.matching.Crew;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CrewGeneratorTest {

    @Test
    void 임의의_값을_넣을때_크루가_만들어지는가() {
        var crewGenerator = new CrewGenerator(new FakeFileReader(List.of("가나", "가나다")), new FakeShuffle());

        var crews = crewGenerator.generateCrews(Course.BACKEND);

        Assertions.assertThat(crews)
                .isEqualTo(List.of(new Crew(Course.BACKEND, "가나"), new Crew(Course.BACKEND, "가나다")));
    }


    @Test
    void 입력받은_파일에서_크기가_2보다_작은경우_에러를_발생시킵니다() {
        Assertions.assertThatIllegalStateException()
                .isThrownBy(() -> {
                    var generator = new CrewGenerator(new FakeFileReader(List.of("가나")), new FakeShuffle());
                    generator.generateCrews(Course.BACKEND);
                });
    }

    @Test
    void 입력받은_파일에서_중복되는_이름을_가지는_크루가_있으면_에러를_발생시킵니다() {
        Assertions.assertThatIllegalStateException()
                .isThrownBy(() -> {
                    var generator = new CrewGenerator(new FakeFileReader(List.of("가나", "가나")), new FakeShuffle());
                    generator.generateCrews(Course.BACKEND);
                });
    }

}