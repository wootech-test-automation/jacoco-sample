package pairmatching.utils;

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
            throw new IllegalArgumentException();
        }
    }

}
