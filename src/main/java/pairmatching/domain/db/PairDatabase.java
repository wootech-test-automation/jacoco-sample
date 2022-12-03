package pairmatching.domain.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.domain.type.Course;
import pairmatching.domain.type.Mission;
import pairmatching.domain.type.Pair;

public class PairDatabase {

    private static final String NOT_FOUND = "매칭 이력이 없습니다.";

    private final Map<String, List<Pair>> memory = new HashMap<>();


    public void addAll(Course course, Mission mission, List<Pair> pairs) {
        memory.computeIfAbsent(course.toString() + " " + mission.toString(), key -> new ArrayList<>()).addAll(pairs);
    }

    public boolean exist(Course course, Mission mission) {
        return memory.containsKey(course.toString() + " " + mission.toString());
    }

    public boolean existPair(String inputKey, Pair data) {
        List<String> keys = findKeys(inputKey);
        return keys.stream().map(memory::get)
                .anyMatch(pairs -> matchPair(pairs, data));
    }

    public List<Pair> getAll(Course course, Mission mission) {
        List<Pair> pairs = memory.get(course.toString() + " " + mission.toString());
        if (pairs == null) {
            throw new IllegalArgumentException(NOT_FOUND);
        }
        return pairs;
    }

    public void clear() {
        memory.clear();
    }

    private List<String> findKeys(String inputKey) {
        return memory.keySet().stream()
                .filter(key -> key.contains(inputKey))
                .collect(Collectors.toList());
    }

    private boolean matchPair(List<Pair> pairs, Pair value) {
        return pairs.stream()
                .anyMatch(pair -> pair.equals(value));
    }
}
