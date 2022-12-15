package pairmatching.domain;

public class PairMatching {
    private final CourseInformation courseInformation;
    private final Crews crews;

    public PairMatching(final CourseInformation courseInformation, final Crews crews) {
        this.courseInformation = courseInformation;
        this.crews = crews;
    }
}
