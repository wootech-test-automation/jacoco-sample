package pairmatching.domain.type;

import java.util.stream.Stream;

public enum Feature {
    PAIR_MATCHING("페어 매칭", "1"),
    PAIR_SEARCH("페어 조회", "2"),
    PAIR_INITIALIZE("페어 초기화", "3"),
    QUIT("종료", "Q");

    private static final String INVALID_FEATURE_KEY = "1,2,3,Q 이외에 다른 값을 입력할 수 없습니다.";
    private final String name;
    private final String keyType;

    Feature(String name, String keyType) {
        this.name = name;
        this.keyType = keyType;
    }

    public static Feature matchOf(String keyType) {
        return Stream.of(Feature.values())
                .filter(feature -> keyType.equals(feature.keyType))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_FEATURE_KEY));
    }

    public String getName() {
        return name;
    }

    public String getKeyType() {
        return keyType;
    }
}
