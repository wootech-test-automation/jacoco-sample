package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import pairmatching.CrewNameReader;
import pairmatching.utils.Shuffler;

public class PairMatchingService {

    private final Shuffler shuffler;
    private final CrewNameReader crewNameReader;

    public PairMatchingService(Shuffler shuffler, CrewNameReader crewNameReader) {
        this.shuffler = shuffler;
        this.crewNameReader = crewNameReader;
    }

    public List<Pair> match(PairOption pairOption) {
        List<String> crewNames = crewNameReader.readCrewNames(pairOption.sendPath());
        List<String> afterMatch = shuffler.shuffle(crewNames);
        List<Crew> crews = afterMatch.stream()
                .map(names -> new Crew(pairOption.getCourse(), names))
                .collect(Collectors.toList());
        return Pair.createPairs(crews);
    }
}
