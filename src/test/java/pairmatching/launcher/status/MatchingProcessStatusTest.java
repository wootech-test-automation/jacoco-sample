package pairmatching.launcher.status;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pairmatching.launcher.context.FakePairmatchingContext;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchingProcessStatusTest {


    @Test
    void 매칭_처리상태에서_중복된_매칭이_일어난_경우_다시매칭한다() {

        new MatchingProcessStatus().next(new FakePairmatchingContext());
    }

}