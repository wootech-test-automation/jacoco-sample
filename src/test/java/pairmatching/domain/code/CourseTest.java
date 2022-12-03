package pairmatching.domain.code;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CourseTest {

    @Test
    void 과정이_가지고있는_이름들을_구분자를_통해서_구분할_수_있습니다() {
        var actual = Course.names();
        assertThat(actual).isEqualTo("백엔드 | 프론트엔드");
    }

}