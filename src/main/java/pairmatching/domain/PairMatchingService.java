package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.CrewNameReader;
import pairmatching.utils.Shuffler;

public class PairMatchingService {

    private final PairMatchingRepository pairMatchingRepository;
    private final Shuffler shuffler;
    private final CrewNameReader crewNameReader;

    public PairMatchingService(PairMatchingRepository pairMatchingRepository, Shuffler shuffler,
                               CrewNameReader crewNameReader) {
        this.pairMatchingRepository = pairMatchingRepository;
        this.shuffler = shuffler;
        this.crewNameReader = crewNameReader;
    }

    public boolean hasMatchResult(PairOption pairOption) {
        return pairMatchingRepository.hasPairOption(pairOption);
    }

    public List<Pair> match(PairOption pairOption) {
        List<String> crewNames = crewNameReader.readCrewNames(pairOption.sendPath());
        List<String> afterMatch = shuffler.shuffle(crewNames);
        List<Crew> crews = afterMatch.stream()
                .map(names -> new Crew(pairOption.getCourse(), names))
                .collect(Collectors.toList());
        List<Pair> pairs = Pair.createPairs(crews);
        pairMatchingRepository.save(pairOption, pairs);
        return pairs;
    }

    public List<Pair> getPairResult(PairOption pairOption) {
        return pairMatchingRepository.findPairResult(pairOption);
    }

    public void resetMatchResult() {
        pairMatchingRepository.reset();
    }
}
