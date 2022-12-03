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

    //TODO 리팩토링
    private static List<Pair> pairMatching(List<Crew> crews) {
        if (crews.size() % 2 == 1) {
            return IntStream.range(0, crews.size())
                    .limit(crews.size()-1)
                    .filter(i -> i % 2 == 0)
                    .mapToObj(idx -> {
                        if (idx == crews.size() - 3) {
                            return new Pair((crews.get(idx)), crews.get(idx + 1), crews.get(idx + 2));
                        }
                        return new Pair(crews.get(idx), crews.get(idx + 1));
                    })
                    .collect(Collectors.toList());
        }
        return IntStream.range(0, crews.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(idx -> new Pair(crews.get(idx), crews.get(idx + 1)))
                .collect(Collectors.toList());
    }
}
