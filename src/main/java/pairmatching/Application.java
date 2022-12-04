package pairmatching;

import pairmatching.system.PairmatchingContextImpl;
import pairmatching.system.PairmatchingLauncher;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        var pairmatchingLauncher = new PairmatchingLauncher(
                new PairmatchingContextImpl(),
                new InputView(),
                new OutputView()
        );
        pairmatchingLauncher.execute();
    }
}
