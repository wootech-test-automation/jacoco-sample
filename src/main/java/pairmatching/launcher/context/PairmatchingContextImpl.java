package pairmatching.launcher.context;

import pairmatching.view.PairmatchingView;

public class PairmatchingContextImpl implements PairmatchingContext {
    private final PairmatchingView pairmatchingView;

    public PairmatchingContextImpl(PairmatchingView pairmatchingView) {
        this.pairmatchingView = pairmatchingView;
    }

    public PairmatchingView getPairmatchingView() {
        return this.pairmatchingView;
    }
}
