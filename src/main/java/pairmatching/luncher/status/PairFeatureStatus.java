package pairmatching.luncher.status;

import pairmatching.luncher.controller.PairMatchingController;
import pairmatching.domain.type.Feature;
import pairmatching.luncher.status.match.PairMatchingStatus;

public class PairFeatureStatus implements PairStatus {

    @Override
    public PairStatus next(PairMatchingController context) {
        Feature feature = context.inputFeature();
        return chooseStatus(feature);
    }

    @Override
    public boolean isRunnable() {
        return true;
    }

    private PairStatus chooseStatus(Feature feature) {
        if (feature.equals(Feature.PAIR_MATCHING)) {
            return new PairMatchingStatus();
        }
        if (feature.equals(Feature.PAIR_SEARCH)) {
            return new PairSearchStatus();
        }
        if (feature.equals(Feature.PAIR_INITIALIZE)) {
            return new PairResetStatus();
        }
        return new PairQuitStatus();
    }
}
