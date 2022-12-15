package pairmatching.domain;

import java.util.List;

public class Pair {
    public static final String SEPARATOR = " : ";
    private final List<Crew> pair;

    public Pair(final List<Crew> pair) {
        this.pair = pair;
    }

    public boolean containsPair(List<Pair> pairs) {
        return pairs.stream()
                .map(input -> input.pair)
                .anyMatch(pair -> pair.containsAll(this.pair));
    }

    @Override
    public String toString() {
        StringBuilder log = new StringBuilder();
        pair.stream()
                .map(Crew::getName)
                .limit(pair.size() - 1)
                .forEach(name -> log.append(name).append(SEPARATOR));
        log.append(pair.get(pair.size() - 1).getName());
        return log.toString();
    }
}
