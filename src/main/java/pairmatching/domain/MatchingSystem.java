package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.type.CourseLevelMission;
import pairmatching.domain.type.Mission;
import pairmatching.domain.type.Pair;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchingSystem {
    private final CrewRepository crewRepository = new CrewRepository();
    private final PairRepository pairRepository = new PairRepository();

    public void matching(CourseLevelMission clmDto) {
        checkAlreadyMission(clmDto.getMission());

        List<String> crewNames = crewRepository.getCrew(clmDto.getCourse());
        List<String> shuffledCrew = Randoms.shuffle(crewNames);

        for (Pair pair : groupingPairs(clmDto, shuffledCrew)) {
            pairRepository.create(pair);
        }
    }

    private void checkAlreadyMission(Mission mission) {
        if (pairRepository.isHaveMission(mission)) {
            throw new IllegalStateException("이 미션은 이미 페어매칭 동작햇습니다~~ " + mission.toString());
        }
    }

    private List<Pair> groupingPairs(CourseLevelMission clmDto, List<String> shuffledCrew) {
        List<Pair> result = new ArrayList<>();
        List<String> queue = new ArrayList<>();
        for(String name : shuffledCrew) {
            queue.add(name);
            if (queue.size() == 2) {
                result.add(new Pair(clmDto, queue));
                queue.clear();
            }
        }
        return result;
    }

    public List<Pair> select(CourseLevelMission clmDto) {
        return pairRepository.findPairsByClm(clmDto);
    }

    public void reset() {
        pairRepository.deleteAll();
    }
}
