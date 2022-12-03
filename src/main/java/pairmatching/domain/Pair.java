package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pair {

    private List<Crew> crews;

    private Pair(Crew... crews) {
        this.crews = List.of(crews);
    }

    public static List<Pair> createPairs(List<Crew> crews) {
        return pairMatching(crews);
    }

    public List<String> getNames() {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    //TODO 홀수 처리 기능
    private static List<Pair> pairMatching(List<Crew> crews) {
        return IntStream.range(0, crews.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(idx -> new Pair(crews.get(idx), crews.get(idx + 1)))
                .collect(Collectors.toList());
    }
}
