package pairmatching;

import pairmatching.config.PairMatchingAppFactory;

public class Application {
    public static void main(String[] args) {
        PairMatchingAppFactory factory = new PairMatchingAppFactory();
        factory.runApp();
    }
}
