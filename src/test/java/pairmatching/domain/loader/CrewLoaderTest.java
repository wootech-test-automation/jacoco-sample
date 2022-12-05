package pairmatching.domain.loader;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.domain.type.Course;
import pairmatching.domain.type.Crew;

class CrewLoaderTest {

    @Test
    void shouldReturnBackendCrewWhenInputBackendCourse() {
        // given
        CrewLoader crewLoader = new CrewLoader();

        // when
        List<Crew> crews = crewLoader.getNames(Course.BACKEND);

        // then
        crews.forEach(crew -> assertThat(crew.getCourse()).isEqualTo(Course.BACKEND));
    }

    @Test
    void shouldReturnFrontendCrewWhenInputFrontendCourse() {
        // given
        CrewLoader crewLoader = new CrewLoader();

        // when
        List<Crew> crews = crewLoader.getNames(Course.FRONTEND);

        // then
        crews.forEach(crew -> assertThat(crew.getCourse()).isEqualTo(Course.FRONTEND));
    }
}