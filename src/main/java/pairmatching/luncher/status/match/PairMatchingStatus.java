package pairmatching.luncher.status.match;

import pairmatching.exception.DuplicateException;
import pairmatching.exception.DuplicatePairException;
import pairmatching.luncher.controller.PairMatchingController;
import pairmatching.luncher.status.PairFeatureStatus;
import pairmatching.luncher.status.PairRetryStatus;
import pairmatching.luncher.status.PairStatus;

public class PairMatchingStatus implements PairStatus {

    @Override
    public PairStatus next(PairMatchingController context) {
        try {
            context.requestPairMatch();
            return new PairFeatureStatus();
        } catch (DuplicateException e) {
            return new PairRetryStatus();
        } catch (DuplicatePairException e) {
            return new PairDirectMatchingStatus(1);
        }
    }

    @Override
    public boolean isRunnable() {
        return true;
    }
}
