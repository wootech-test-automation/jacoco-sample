package pairmatching.code;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pairmatching.domain.code.Level;
import pairmatching.domain.code.Mission;
import pairmatching.domain.code.Subject;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MissionTest {

    @Test
    void 레벨에_맞지않는_입력일_경우_오류가_발생합니다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Mission.validateExistsSubjectInLevel(Level.LEVEL1, Subject.DEPLOY));
    }

}