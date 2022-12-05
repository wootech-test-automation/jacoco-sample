package pairmatching.luncher.controller;

import java.util.Set;
import pairmatching.domain.PairMatchingGame;
import pairmatching.domain.type.Feature;
import pairmatching.domain.type.MatchingInformation;
import pairmatching.domain.type.Pair;
import pairmatching.domain.type.YesOrNo;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final PairMatchingGame pairMatchingGame = new PairMatchingGame();
    private MatchingInformation cache;
    public Feature inputFeature() {
        return inputView.inputFeature();
    }

    public void requestPairMatch() {
        MatchingInformation matchingInformation = inputView.inputMatchInformation();
        Set<Pair> pairs = pairMatchingGame.pairMatch(matchingInformation);
        outputView.showResult(pairs);
        cache = matchingInformation;
    }

    public void requestShowMatchedCrew() {
        MatchingInformation matchingInformation = inputView.inputMatchInformation();
        Set<Pair> pairs = pairMatchingGame.showPair(matchingInformation);
        outputView.showResult(pairs);
    }

    public void requestRePairMatch() {
        MatchingInformation matchingInformation = inputView.inputReMatchInformation();
        Set<Pair> pairs = pairMatchingGame.reMatch(matchingInformation);
        outputView.showResult(pairs);
        cache = matchingInformation;
    }

    public void directMatch() {
        Set<Pair> pairs = pairMatchingGame.reMatch(cache);
        outputView.showResult(pairs);
        cache = null;
    }

    public YesOrNo requestRetry() {
        return inputView.inputRepeat();
    }

    public void requestReset() {
        pairMatchingGame.reset();
    }

    public void printError(String message) {
        outputView.printError(message);
    }
}
