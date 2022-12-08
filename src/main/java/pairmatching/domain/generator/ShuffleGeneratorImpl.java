package pairmatching.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class ShuffleGeneratorImpl implements ShuffleGenerator {

    @Override
    public List<String> shuffle(List<String> input) {
        return Randoms.shuffle(input);
    }
}
