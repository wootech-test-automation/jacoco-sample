package pairmatching.launcher.status;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pairmatching.launcher.code.MatchingInitializeStatus;
import pairmatching.launcher.context.FakePairmatchingContext;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SelectFeatureStatusTest extends NsTest {

    PairmatchingStatus getNextStatus() {
        return new SelectFeatureStatus().next(new FakePairmatchingContext());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 기능선택하는상태에서_1_2를_입력하면_다음은_입력상태로_넘어간다(final String input) {
        run(input);
        Assertions.assertThat(this.getNextStatus())
                .isInstanceOf(InputStatus.class);
    }

    @Test
    void 기능선택상태에서_3을_입력하면_매칭_초기화_상태가_된다() {
        run("3");
        Assertions.assertThat(this.getNextStatus())
                .isInstanceOf(MatchingInitializeStatus.class);
    }

    @Test
    void 기능선택상태에서_Q_를_입력하면_종료상태가_된다() {
        run("Q");
        Assertions.assertThat(this.getNextStatus())
                .isInstanceOf(QuitStatus.class);
    }

    @Override
    protected void runMain() {

    }
}