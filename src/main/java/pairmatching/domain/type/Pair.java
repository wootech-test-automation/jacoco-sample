package pairmatching.domain.type;

import java.util.Objects;

public class Pair {
    private final Crew first;
    private final Crew second;
    private final Crew third;

    public Pair(Crew first, Crew second) {
        this.first = first;
        this.second = second;
        this.third = null;
    }

    public Pair(Crew first, Crew second, Crew third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        return Objects.equals(first, pair.first) && Objects.equals(second,
                pair.second) && Objects.equals(third, pair.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    public Crew getFirst() {
        return first;
    }

    public Crew getSecond() {
        return second;
    }

    public Crew getThird() {
        return third;
    }

    @Override
    public String toString() {
        String result = first + " : " + second;
        if (third != null) {
            result = result + " : " + third;
        }
        return result;
    }
}
