package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.domain.PairOption;
import pairmatching.domain.command.Course;
import pairmatching.domain.command.Function;
import pairmatching.domain.command.Level;
import pairmatching.domain.command.Mission;
import pairmatching.domain.command.Rematching;

public class InputView {

    public Function selectProgramFunction() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");

        return Function.of(Console.readLine());
    }

    public PairOption selectSpecificPairOption() {
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");
        System.out.println("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        System.out.println("  - 레벨2: 장바구니 | 결제 | 지하철노선도");
        System.out.println("  - 레벨3: ");
        System.out.println("  - 레벨4: 성능개선 | 배포");
        System.out.println("  - 레벨5: ");
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.");

        return getPairOption(Console.readLine());
    }

    public Rematching selectWhetherToReMatching() {
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
        return Rematching.of(Console.readLine());
    }

    private PairOption getPairOption(String input) {
        List<String> commands = List.of(input.split(", "));
        Course course = Course.of(commands.get(0));
        Level level = Level.of(commands.get(1));
        Mission mission = Mission.from(commands.get(2), level.command);
        return new PairOption(course, level, mission);
    }
}
