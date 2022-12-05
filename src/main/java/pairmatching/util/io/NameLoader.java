package pairmatching.util.io;

import java.util.List;

public interface NameLoader<T> {

    List<T> loadNames(String path);
}
