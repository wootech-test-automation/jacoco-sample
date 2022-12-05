package pairmatching.luncher;

import pairmatching.luncher.controller.PairMatchingController;
import pairmatching.luncher.status.PairFeatureStatus;
import pairmatching.luncher.status.PairQuitStatus;
import pairmatching.luncher.status.PairStatus;
import pairmatching.exception.BusinessException;

public class PairMatchingGameLauncher {
    private final PairMatchingController pairMatchingController = new PairMatchingController();
    private PairStatus pairStatus = new PairFeatureStatus();


    public void play() {
        while (pairStatus.isRunnable()) {
            try {
                pairStatus = pairStatus.next(pairMatchingController);
            } catch(BusinessException e) {
                pairMatchingController.printError(e.getMessage());
                pairStatus = new PairFeatureStatus();
            } catch (IllegalArgumentException | IllegalStateException e) {
                pairMatchingController.printError(e.getMessage());
                pairStatus = new PairQuitStatus();
            }
        }
    }
}
