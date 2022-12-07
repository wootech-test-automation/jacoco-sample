package pairmatching.repository;

import pairmatching.domain.type.CourseLevelMission;
import pairmatching.domain.type.Mission;
import pairmatching.domain.type.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairRepository {
    List<Pair> pairs = new ArrayList<Pair>();

    // create item
    public void create(Pair pair) {
        validateSameLevelPair(pair);  // 같은레벨에 중복크루가 이미 있는지 확인
        pairs.add(pair);
    }

    public boolean isHaveMission(Mission mission) {
        return pairs.stream().anyMatch(p -> p.isSameMission(mission));
    }

    private void validateSameLevelPair(Pair pair) {
        pairs.stream()
                .filter(p -> p.isSameLevel(pair))
                .filter(p -> p.isSameCrew(pair))
                .findAny()
                .ifPresent(p -> {throw new IllegalStateException("이미 중복된 크루가 있습니다~~ " + p.toString());});
    }

    // find all
    public List<Pair> findPairsByClm(CourseLevelMission clmDto) {
        return pairs.stream()
                .filter(pair -> pair.isSameCourse(clmDto.getCourse()))
                .filter(pair -> pair.isSameLevel(clmDto.getLevel()))
                .filter(pair -> pair.isSameMission(clmDto.getMission()))
                .collect(Collectors.toList());
    }

    // delete all
    public void deleteAll() {
        pairs = new ArrayList<Pair>();
    }
}
