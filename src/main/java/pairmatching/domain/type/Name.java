package pairmatching.domain.type;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {

    private static final String NAME_ERROR = "이름 똑바로 입력하세요.";
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        Matcher matcher = Pattern.compile("^[a-zA-Z가-힣]{1,10}$").matcher(name);
        if (matcher.matches()) {
            return;
        }
        throw new IllegalStateException(NAME_ERROR);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
