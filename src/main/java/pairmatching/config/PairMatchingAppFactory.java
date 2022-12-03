package pairmatching.config;

import pairmatching.CrewNameReader;
import pairmatching.domain.PairMatchingApplication;
import pairmatching.domain.PairMatchingRepository;
import pairmatching.domain.PairMatchingService;
import pairmatching.utils.CrewNameShuffler;
import pairmatching.utils.Shuffler;
import pairmatching.view.InputView;
import pairmatching.view.InputViewProxy;
import pairmatching.view.OutputView;

public class PairMatchingAppFactory {

    private final PairMatchingApplication pairMatchingApplication;

    public PairMatchingAppFactory() {
        this.pairMatchingApplication = initPairMatchingApplication();
    }

    public void runApp() {
        pairMatchingApplication.run();
    }

    private PairMatchingApplication initPairMatchingApplication() {
        return new PairMatchingApplication(initInputView(), initOutputView(), initPairMatchingService());
    }

    private InputView initInputView() {
        return new InputViewProxy(new InputView());
    }

    private OutputView initOutputView() {
        return new OutputView();
    }

    private PairMatchingService initPairMatchingService() {
        return new PairMatchingService(initPairMatchingRepository(), initShuffler(), initCrewNameReader());
    }

    private PairMatchingRepository initPairMatchingRepository() {
        return new PairMatchingRepository();
    }

    private Shuffler initShuffler() {
        return new CrewNameShuffler();
    }

    private CrewNameReader initCrewNameReader() {
        return new CrewNameReader();
    }
}
