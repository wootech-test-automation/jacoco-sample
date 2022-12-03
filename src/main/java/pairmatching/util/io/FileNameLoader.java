package pairmatching.util.io;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.type.Name;


public class FileNameLoader implements NameLoader<Name> {

    private static final String IO_ERROR = "파일을 읽는데 에러가 발생했습니다.";

    @Override
    public List<Name> loadNames(String path) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(path);
        if (url == null) {
            return new ArrayList<>();
        }
        List<String> names;
        try {
            names = Files.readAllLines(Paths.get(url.toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new IllegalStateException(IO_ERROR);
        }
        return names.stream().map(Name::new).collect(Collectors.toList());
    }
}
