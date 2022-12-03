package pairmatching.controller;

import java.util.List;
import pairmatching.domain.PairMatchingGame;
import pairmatching.domain.type.Course;
import pairmatching.domain.type.Feature;
import pairmatching.domain.type.Level;
import pairmatching.domain.type.Mission;
import pairmatching.domain.type.Pair;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final PairMatchingGame pairMatchingGame = new PairMatchingGame();

    public void play() {
        try {
            chooseFeature();
        } catch(IllegalArgumentException | IllegalStateException e) {
            outputView.printError(e.getMessage());
        }
    }


    private void chooseFeature() {
        while (true) {
            Feature feature = inputView.inputFeature();
            if (feature.equals(Feature.PAIR_MATCHING)) {
                pairMatch();
            }
            if (feature.equals(Feature.PAIR_SEARCH)) {
                showMatch();
            }
            if (feature.equals(Feature.PAIR_INITIALIZE)) {
                initialize();
            }
            if (feature.equals(Feature.QUIT)) {
                return;
            }
        }
    }

    public void pairMatch() {
        while (true) {
            List<Object> objects = inputView.inputInformation();
            boolean duplicateRequest = pairMatchingGame.isDuplicateRequest((Course) objects.get(0),
                    (Mission) objects.get(2));
            if (duplicateRequest) {
                continue;
            }
            pairMatchingGame.pairMatch((Course) objects.get(0), (Level) objects.get(1), (Mission) objects.get(2));
            List<Pair> pairs = pairMatchingGame.showPair((Course) objects.get(0), (Mission) objects.get(2));
            outputView.showResult(pairs);
            return;
        }
    }

    public void showMatch() {
        try {
            List<Object> objects = inputView.inputInformation();
            List<Pair> pairs = pairMatchingGame.showPair((Course) objects.get(0), (Mission) objects.get(2));
            outputView.showResult(pairs);
        } catch (IllegalArgumentException | IllegalStateException e) {
            outputView.printError(e.getMessage());
        }
    }

    public void initialize() {
        pairMatchingGame.initialize();
        outputView.initialized();
    }
}
