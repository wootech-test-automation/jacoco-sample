package pairmatching.domain.generator;

import java.util.List;

public class FakeFileReader implements ReadFile {

    private final List<String> data;

    public FakeFileReader(List<String> data) {
        this.data = data;
    }

    @Override
    public List<String> readFile(String fileName) {
        return data;
    }
}
