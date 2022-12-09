package pairmatching.launcher.context;

import pairmatching.domain.count.RetryCount;
import pairmatching.domain.generator.CrewGenerator;
import pairmatching.domain.matching.MatchingDivision;
import pairmatching.domain.matching.MatchingResult;
import pairmatching.view.PairmatchingView;

public class PairmatchingContextImpl implements PairmatchingContext {
    private final PairmatchingView pairmatchingView;
    private final CrewGenerator crewGenerator;
    private MatchingResult matchingResult;
    private MatchingDivision matchingDivision;
    private RetryCount retryCount;

    public PairmatchingContextImpl(PairmatchingView pairmatchingView, CrewGenerator crewGenerator) {
        this.pairmatchingView = pairmatchingView;
        this.crewGenerator = crewGenerator;
        this.matchingResult = new MatchingResult();
    }

    public PairmatchingView getPairmatchingView() {
        return this.pairmatchingView;
    }

    @Override
    public void inputMatchingDivision(MatchingDivision matchingDivision) {
        this.matchingDivision = matchingDivision;
    }

    @Override
    public String matchPair() {
        var generatedCrews = crewGenerator.generateCrews(this.matchingDivision.getCourse());

        this.matchingResult.matchPair(this.matchingDivision, generatedCrews);

        return this.matchingResult.findByMatchingDivision(matchingDivision);
    }

    @Override
    public String rematchPair() {
        var generatedCrews = crewGenerator.generateCrews(this.matchingDivision.getCourse());

        this.matchingResult.rematchPair(this.matchingDivision, generatedCrews);

        return this.matchingResult.findByMatchingDivision(matchingDivision);
    }

    @Override
    public String findMatchedCrewsByMatchingDivision() {
        return this.matchingResult.findByMatchingDivision(matchingDivision);
    }

    @Override
    public void plusTryCount() {
        this.retryCount = this.retryCount.plusRetry();

    }

    public void initializeRetryCount() {
        this.retryCount = RetryCount.generateInitializeCount();
    }

    @Override
    public void initializeMatchingResult() {
        this.matchingResult = new MatchingResult();
    }

}
