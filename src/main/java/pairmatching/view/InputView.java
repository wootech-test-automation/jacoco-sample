package pairmatching.view;

import java.util.List;
import pairmatching.domain.type.Feature;
import pairmatching.domain.type.YesOrNo;
import pairmatching.util.io.ConsoleReader;

public class InputView extends View {

    private static final String REQUEST_FEATURE = "기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";

    private static final String REQUEST_INFORMATION = "#############################################\n"
            + "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3: \n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5: \n"
            + "############################################\n"
            + "과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주";

    private static final String REQUEST_YES_OR_NO = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
            + "네 | 아니오";

    public Feature inputFeature() {
        while (true) {
            try {
                print(REQUEST_FEATURE);
                return ConsoleReader.readFeature();
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    public YesOrNo inputRepeat() {
        while (true) {
            try {
                print(REQUEST_YES_OR_NO);
                return ConsoleReader.readYseOrNo();
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    public List<Object> inputInformation() {
        while (true) {
            try {
                print(REQUEST_INFORMATION);
                return ConsoleReader.readInformation();
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }
}
