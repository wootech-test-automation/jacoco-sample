package pairmatching.luncher.status;

import pairmatching.domain.type.YesOrNo;
import pairmatching.luncher.controller.PairMatchingController;
import pairmatching.luncher.status.match.PairDirectMatchingStatus;
import pairmatching.luncher.status.match.PairReMatchingStatus;

public class PairRetryStatus implements PairStatus {

    @Override
    public PairStatus next(PairMatchingController context) {
        YesOrNo yesOrNo = context.requestRetry();
        if (yesOrNo.equals(YesOrNo.YES)) {
            return new PairDirectMatchingStatus(0);
        }
        return new PairReMatchingStatus();
    }

    @Override
    public boolean isRunnable() {
        return true;
    }
}
