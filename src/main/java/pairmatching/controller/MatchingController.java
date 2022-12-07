package pairmatching.controller;

import pairmatching.domain.MatchingSystem;
import pairmatching.domain.type.*;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class MatchingController {
    MatchingSystem matchingSystem = new MatchingSystem();

    public void system() {
        while (true) {
            Command command = readCommand();
            if (command == Command.MATCHING) {
                matching();
            }
            if (command == Command.SELECT) {
                select();
            }
            if (command == Command.RESET) {
                reset();
            }
            if (command == Command.QUIT) {
                break;
            }
        }
    }

    private void matching() {
        CourseLevelMission clmDto = readCourseLevelMission();
        try {
            newMatching(clmDto);
        }
        catch(IllegalStateException e) {
            if (readRematching()) {
                reset();
                newMatching(clmDto);
            }
        }
    }

    private void newMatching(CourseLevelMission clmDto) {
        matchingSystem.matching(clmDto);
        List<Pair> pairs = findPairsByClm(clmDto);
        OutputView.printMatchingResult(pairs);
    }

    private void select() {
        CourseLevelMission clmDto = readCourseLevelMission();
        List<Pair> pairs = findPairsByClm(clmDto);
        if (pairs.isEmpty()) {
            OutputView.printError("아직 매칭 내용이 없습니다.");
        }
        if (!pairs.isEmpty()) {
            OutputView.printMatchingResult(pairs);
        }
    }

    private void reset() {
        matchingSystem.reset();
        OutputView.printResetDone();
    }

    private List<Pair> findPairsByClm(CourseLevelMission clmDto) {
        return matchingSystem.select(clmDto);
    }

    private Command readCommand() {
        while (true) {
            try {
                OutputView.printSelectCommand();
                return InputView.readCommand();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.toString());
            }
        }
    }

    private CourseLevelMission readCourseLevelMission() {
        while (true) {
            try {
                OutputView.printCourseLevelMission();
                return InputView.readCourseLevelMission();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.toString());
            }
        }
    }

    private boolean readRematching() {
        while (true) {
            try {
                OutputView.printRetry();
                return InputView.readRematching();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.toString());
            }
        }
    }
}
