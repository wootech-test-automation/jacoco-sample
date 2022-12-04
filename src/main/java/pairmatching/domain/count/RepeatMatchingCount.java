package pairmatching.domain.count;

public class RepeatMatchingCount {
    private final int count;

    private RepeatMatchingCount(final int count) {
        if (count >= 3) {
            throw new IllegalStateException("더이상 매칭할 수 없습니다.");
        }
        this.count = count;
    }

    public static RepeatMatchingCount initializeRepeatMatchingCount() {
        return new RepeatMatchingCount(1);
    }

    public RepeatMatchingCount plusCount() {
        return new RepeatMatchingCount(count + 1);
    }
}
