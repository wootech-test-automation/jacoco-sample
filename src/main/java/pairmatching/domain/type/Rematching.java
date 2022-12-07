package pairmatching.domain.type;

import java.util.Arrays;
import java.util.Objects;

public enum Rematching {
    YES("네", true),
    NO("아니오", false);

    private final String word;
    private final boolean isYes;


    Rematching(String word, boolean isYes) {
        this.word = word;
        this.isYes = isYes;
    }

    public static boolean wordIsYes(String word) {
        return Arrays.stream(Rematching.values())
                .filter(rematching -> Objects.equals(rematching.getWord(), word))
                .findAny()
                .map(Rematching::getIsYes)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 리매칭 커맨드가 없습니다. " + word));
    }

    private String getWord() {
        return word;
    }

    private boolean getIsYes() {
        return isYes;
    }
}
