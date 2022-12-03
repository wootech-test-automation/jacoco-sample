package pairmatching.domain.command;

import java.util.List;
import pairmatching.CrewNameReader;
import pairmatching.domain.PairOption;
import pairmatching.utils.Shuffler;

public class PairMatchingService {

    private final Shuffler shuffler;
    private final CrewNameReader crewNameReader;

    public PairMatchingService(Shuffler shuffler, CrewNameReader crewNameReader) {
        this.shuffler = shuffler;
        this.crewNameReader = crewNameReader;
    }

    public List<String> match(PairOption pairOption) {
        List<String> crews = crewNameReader.readCrewNames(pairOption.sendPath());
        return shuffler.shuffle(crews);
    }
}
