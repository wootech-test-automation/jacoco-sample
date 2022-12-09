package pairmatching.domain.count;

public class RetryCount {
    private static final int INITIALIZE_COUNT = 0;
    private static final int PLUS_COUNT = 1;
    private static final int MAX_COUNT = 3;
    private final int count;

    private RetryCount(final int count) {
        if (count > MAX_COUNT) {
            throw new IllegalStateException("더이상 시도할 수 없습니다.");
        }
        this.count = count;
    }

    public static RetryCount generateInitializeCount() {
        return new RetryCount(INITIALIZE_COUNT);
    }

    public RetryCount plusRetry() {
        return new RetryCount(this.count + PLUS_COUNT);
    }

}
