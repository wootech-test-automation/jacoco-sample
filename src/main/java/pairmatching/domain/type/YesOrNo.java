package pairmatching.domain.type;

import java.util.stream.Stream;

public enum YesOrNo {
    YES("네"),
    NO("아니오");

    private static final String INVALID_YES_OR_NO_NAME ="네 | 아니오 만 입력해주세요.";
    private final String name;

    YesOrNo(String name) {
        this.name = name;
    }

    public static YesOrNo matchOf(String name) {
        return Stream.of(YesOrNo.values())
                .filter(yesOrNo -> name.equals(yesOrNo.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_YES_OR_NO_NAME));
    }
}
