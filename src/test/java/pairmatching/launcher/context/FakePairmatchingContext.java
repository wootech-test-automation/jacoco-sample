package pairmatching.launcher.context;

import pairmatching.view.PairmatchingView;

public class FakePairmatchingContext implements PairmatchingContext {

    @Override
    public PairmatchingView getPairmatchingView() {
        return null;
    }
}
