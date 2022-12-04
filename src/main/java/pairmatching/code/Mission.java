package pairmatching.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Mission {
    /**
     * - 레벨1: 자동차경주 | 로또 | 숫자야구게임 - 레벨2: 장바구니 | 결제 | 지하철노선도 - 레벨3: - 레벨4: 성능개선 | 배포 - 레벨5:
     */
    STAGE1(Level.LEVEL1, List.of(Subject.RACING, Subject.LOTTO, Subject.BASEBALL)),
    STAGE2(Level.LEVEL2, List.of(Subject.SHOPPING, Subject.PAYMENTS, Subject.SUBWAY)),
    STAGE3(Level.LEVEL3),
    STAGE4(Level.LEVEL4, List.of(Subject.IMPROVEMENT_PERFORMANCE, Subject.DEPLOY)),
    STAGE5(Level.LEVEL5);

    private final Level level;
    private final List<Subject> subjects;

    Mission(Level level, List<Subject> subjects) {
        this.level = level;
        this.subjects = subjects;
    }

    Mission(Level level) {
        this.level = level;
        this.subjects = new ArrayList<>();
    }

    public static void valdiateExistsSubjectInLevel(Level level, Subject subject) {
        var result = Arrays.stream(values()).filter(mission -> mission.level.equals(level))
                .noneMatch(mission -> mission.subjects.contains(subject));
        if (result) {
            throw new IllegalArgumentException("해당 레벨에서 과정은 존재하지 않습니다.");
        }
    }
}
