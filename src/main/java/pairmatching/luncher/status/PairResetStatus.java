package pairmatching.luncher.status;

import pairmatching.luncher.controller.PairMatchingController;

public class PairResetStatus implements PairStatus {

    @Override
    public PairStatus next(PairMatchingController context) {
        context.requestReset();
        return new PairFeatureStatus();
    }

    @Override
    public boolean isRunnable() {
        return false;
    }
}
