package pairmatching.launcher.context;

import pairmatching.domain.generator.CrewGenerator;
import pairmatching.domain.matching.MatchingDivision;
import pairmatching.view.PairmatchingView;

public class PairmatchingContextImpl implements PairmatchingContext {
    private final PairmatchingView pairmatchingView;
    private final CrewGenerator crewGenerator;
    private MatchingDivision matchingDivision;

    public PairmatchingContextImpl(PairmatchingView pairmatchingView, CrewGenerator crewGenerator) {
        this.pairmatchingView = pairmatchingView;
        this.crewGenerator = crewGenerator;
    }

    public PairmatchingView getPairmatchingView() {
        return this.pairmatchingView;
    }

    @Override
    public void inputMatchingDivision(MatchingDivision matchingDivision) {
        this.matchingDivision = matchingDivision;
    }

}
