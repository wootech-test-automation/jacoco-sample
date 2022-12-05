package pairmatching.db;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import pairmatching.domain.type.MatchingInformation;
import pairmatching.domain.type.Pair;

public class Database {

    private final Map<String, Set<Pair>> memory = new HashMap<>();

    public void addAll(MatchingInformation matchingInformation, List<Pair> pairs) {
        memory.computeIfAbsent(matchingInformation.toString(), key -> new LinkedHashSet<>())
                .addAll(pairs);
    }

    public boolean exist(MatchingInformation matchingInformation) {
        return memory.containsKey(matchingInformation.toString());
    }

    public boolean existPair(String inputKey, Pair data) {
        List<String> keys = findKeys(inputKey);
        return keys.stream().map(memory::get)
                .anyMatch(pairs -> matchPair(pairs, data));
    }

    public Set<Pair> getAll(MatchingInformation matchingInformation) {
        Set<Pair> pairs = memory.get(matchingInformation.toString());
        if (pairs == null) {
            return new LinkedHashSet<>();
        }
        return pairs;
    }

    public void clear() {
        memory.clear();
    }

    public void removeKey(MatchingInformation matchingInformation) {
        memory.remove(matchingInformation.toString());
    }

    private List<String> findKeys(String inputKey) {
        return memory.keySet().stream()
                .filter(key -> key.contains(inputKey))
                .collect(Collectors.toList());
    }

    private boolean matchPair(Set<Pair> pairs, Pair value) {
        return pairs.stream()
                .anyMatch(pair -> pair.equals(value));
    }
}
