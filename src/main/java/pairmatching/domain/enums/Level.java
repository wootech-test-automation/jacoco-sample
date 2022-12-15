package pairmatching.domain.enums;

import java.util.Collections;
import java.util.List;

/**
 *  자동차경주 | 로또 | 숫자야구게임
 *   - 레벨2: 장바구니 | 결제 | 지하철노선도
 *   - 레벨3:
 *   - 레벨4: 성능개선 | 배포
 */
public enum Level {
    LEVEL1("레벨1", List.of(Mission.CAR_RACING, Mission.LOTTO, Mission.BASEBALL)),
    LEVEL2("레벨2", List.of(Mission.BASKET, Mission.PAYMENT, Mission.SUBWAY_PATH)),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", List.of(Mission.PERFORMANCE, Mission.DISTRIBUTION)),
    LEVEL5("레벨5", Collections.emptyList());

    private String name;
    private List<Mission> missions;

    Level(final String name, final List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

// 추가 기능 구현
}
