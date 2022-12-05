package pairmatching.luncher.status.match;

import pairmatching.exception.DuplicateException;
import pairmatching.exception.DuplicatePairException;
import pairmatching.exception.ExceedTryCountException;
import pairmatching.luncher.controller.PairMatchingController;
import pairmatching.luncher.status.PairFeatureStatus;
import pairmatching.luncher.status.PairRetryStatus;
import pairmatching.luncher.status.PairStatus;

public class PairDirectMatchingStatus implements PairStatus {

    private static final int LIMIT_MAX_TRY = 3;
    private final int tryCount;

    public PairDirectMatchingStatus(int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }
    @Override
    public PairStatus next(PairMatchingController context) {
        try {
            context.directMatch();
            return new PairFeatureStatus();
        } catch (DuplicateException e) {
            return new PairRetryStatus();
        } catch (DuplicatePairException e) {
            return new PairDirectMatchingStatus(tryCount + 1);
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount >= LIMIT_MAX_TRY) {
            throw new ExceedTryCountException(tryCount);
        }
    }

    @Override
    public boolean isRunnable() {
        return true;
    }
}
