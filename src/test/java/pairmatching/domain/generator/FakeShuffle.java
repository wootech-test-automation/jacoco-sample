package pairmatching.domain.generator;

import java.util.List;

public class FakeShuffle implements ShuffleGenerator {
    @Override
    public List<String> shuffle(List<String> input) {
        return input;
    }
}
