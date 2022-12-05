package pairmatching.luncher.status;

import pairmatching.luncher.controller.PairMatchingController;
import pairmatching.exception.EmptyMatchedCrewException;

public class PairSearchStatus implements PairStatus {

    @Override
    public PairStatus next(PairMatchingController context) {
        try {
            context.requestShowMatchedCrew();
        } catch(EmptyMatchedCrewException e) {
            context.printError(e.getMessage());
        }
        return new PairFeatureStatus();
    }

    @Override
    public boolean isRunnable() {
        return true;
    }
}
