package pairmatching.utils;

import static java.text.MessageFormat.format;

import java.util.List;

public class ValueChecker {

    private final List<String> values;

    public static ValueChecker createFromRightValues(String... values) {
        return new ValueChecker(List.of(values));
    }

    private ValueChecker(List<String> values) {
        this.values = values;
    }

    public void validate(String input) {
        if (!values.contains(input)) {
            throw new IllegalArgumentException(format("{0} 이외의 값은 허용되지 않습니다. 입력값 : {1}",
                    String.join(",", values), input));
        }
    }
}
