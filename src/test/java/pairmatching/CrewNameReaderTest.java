package pairmatching;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.domain.command.Course;

class CrewNameReaderTest {

    private CrewNameReader nameReader = new CrewNameReader();

    @DisplayName("백엔드 크루 20명의 이름을 가져온다.")
    @Test
    void test1() {
        List<String> backendCrewNames = nameReader.readCrewNames(Course.BACKEND.getPath());
        assertThat(backendCrewNames.size()).isEqualTo(20);
    }

    @DisplayName("백엔드 크루들의 이름이 포함됐는지 확인한다. ")
    @Test
    void test2() {
        List<String> backendCrewNames = nameReader.readCrewNames(Course.BACKEND.getPath());
        assertThat(backendCrewNames.contains("백호")).isTrue();
        assertThat(backendCrewNames.contains("태웅")).isTrue();
        assertThat(backendCrewNames.contains("치수")).isTrue();
        assertThat(backendCrewNames.contains("태섭")).isTrue();
        assertThat(backendCrewNames.contains("대만")).isTrue();
    }

    @DisplayName("프론트엔드 크루 15명의 이름을 가져온다.")
    @Test
    void test3() {
        List<String> frontendCrewNames = nameReader.readCrewNames(Course.FRONTEND.getPath());
        assertThat(frontendCrewNames.size()).isEqualTo(15);

    }

    @DisplayName("프론트엔드 크루들의 이름이 포함됐는지 확인한다. ")
    @Test
    void test4() {
        List<String> frontendCrewNames = nameReader.readCrewNames(Course.FRONTEND.getPath());
        assertThat(frontendCrewNames.contains("보노")).isTrue();
        assertThat(frontendCrewNames.contains("시저")).isTrue();
        assertThat(frontendCrewNames.contains("쉐리")).isTrue();
    }
}