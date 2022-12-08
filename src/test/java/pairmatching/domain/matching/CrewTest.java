package pairmatching.domain.matching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pairmatching.domain.code.Course;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CrewTest {


    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "    "})
    void 크루의_이름은_비어있을_수_없습니다(final String input) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Crew(Course.BACKEND, input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"가", "나다"})
    void 크루의_이름과_강좌가_같으면_같은_크루입니다(final String input) {
        var actual = new Crew(Course.BACKEND, input);
        var expected = new Crew(Course.BACKEND, input);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가", "나"})
    void 크루의_이름이_같고_강좌가_다르면_다른_크루입니다(final String input) {
        var target = new Crew(Course.BACKEND, input);
        var original = new Crew(Course.FRONTEND input);

        Assertions.assertThat(original).isEqualTo(target);
    }

}