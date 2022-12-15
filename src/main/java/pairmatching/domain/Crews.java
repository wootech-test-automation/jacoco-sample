package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {
    private final List<Crew> crews;

    public Crews(final List<Crew> crews) {
        this.crews = crews;
    }

    public List<Pair> makePairList() {
        if (crews.size() % 2 == 0) {
            return createEvenPair();
        }
        return createOddPair();
    }

    private List<Pair> createOddPair() {
        List<Pair> pairs = new ArrayList<>();
        for (int index = 0; index < crews.size(); index++) {
            if (index == crews.size() - 3) {
                pairs.add(new Pair(List.of(crews.get(index), crews.get(index + 1), crews.get(index + 2))));
                break;
            }
            if (index % 2 == 1) {
                pairs.add(new Pair(List.of(crews.get(index - 1), crews.get(index))));
            }
        }
        return pairs;
    }

    private List<Pair> createEvenPair() {
        List<Pair> pairs = new ArrayList<>();
        for (int index = 0; index < crews.size(); index++) {
            if (index % 2 == 1) {
                pairs.add(new Pair(List.of(crews.get(index - 1), crews.get(index))));
            }
        }
        return pairs;
    }

    public List<String> getCrewNameList() {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
