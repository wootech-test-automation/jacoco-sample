package pairmatching.launcher.status;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import pairmatching.launcher.context.PairmatchingContextImpl;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InitStatusTest {

    @Test
    void 초기화_상태_다음은_사용자_기능선택_상태입니다() {
        var actualStatus = new InitStatus().next(new PairmatchingContextImpl());
        var expectedStatus = new SelectFeatureStatus();
        Assertions.assertThat(actualStatus).isInstanceOf(expectedStatus.getClass());

    }

}