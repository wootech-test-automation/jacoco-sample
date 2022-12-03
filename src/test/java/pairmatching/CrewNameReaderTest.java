package pairmatching;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrewNameReaderTest {

    private CrewNameReader nameReader = new CrewNameReader();

    @DisplayName("백엔드 크루 20명의 이름을 가져온다")
    @Test
    void test1() throws IOException {
        List<String> backendCrewNames = nameReader.readBackendCrewNames();
        assertThat(backendCrewNames.size()).isEqualTo(20);
    }
}