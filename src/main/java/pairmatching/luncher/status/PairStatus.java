package pairmatching.luncher.status;

import pairmatching.luncher.controller.PairMatchingController;

public interface PairStatus {

    PairStatus next(PairMatchingController context);

    boolean isRunnable();
}
