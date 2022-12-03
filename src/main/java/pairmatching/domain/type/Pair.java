package pairmatching.domain.type;

import java.util.Objects;

public class Pair {
    private final Mission mission;
    private final Crew first;
    private final Crew second;
    private final Crew third;

    public Pair(Mission mission, Crew first, Crew second) {
        this.mission = mission;
        this.first = first;
        this.second = second;
        this.third = null;
    }

    public Pair(Mission mission, Crew first, Crew second, Crew third) {
        this.mission = mission;
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
        return mission == pair.mission && Objects.equals(first, pair.first) && Objects.equals(second,
                pair.second) && Objects.equals(third, pair.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mission, first, second, third);
    }

    public Mission getMission() {
        return mission;
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
        return "Pair{" +
                "mission=" + mission +
                ", first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
