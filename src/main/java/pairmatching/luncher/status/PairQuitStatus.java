package pairmatching.luncher.status;

import pairmatching.luncher.controller.PairMatchingController;

public class PairQuitStatus implements PairStatus {

    @Override
    public PairStatus next(PairMatchingController context) {
        return null;
    }

    @Override
    public boolean isRunnable() {
        return false;
    }
}
