package pairmatching.view;

public class PairmatchingView {
    private final InputView inputView;
    private final OutputView outputView;

    public PairmatchingView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }
}
