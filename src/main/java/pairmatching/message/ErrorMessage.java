package pairmatching.message;


public class ErrorMessage {


    public static final String MENU_SELECT_ERROR = "[ERROR] '1, 2, 3, Q'만 입력할 수 있습니다.";
    public static final String COURSE_INFORMATION_ERROR = "[ERROR] '백엔드, 레벨1, 자동차경주'과 같이 입력해야 합니다.";
    public static final String FILE_NOT_FOUND_ERROR = "[ERROR] 파일을 찾을 수 없습니다.";
    public static final String NO_COURSE_ERROR = "[ERROR] 존재하지 않는 코스입니다.";
    public static final String NO_LEVEL_ERROR = "[ERROR] 존재하지 않는 레벨입니다.";
    public static final String NO_MISSION_ERROR = "[ERROR] 존재하지 않는 미션입니다.";
    public static final String NO_MISSION_IN_LEVEL_ERROR = "[ERROR] 해당 레벨에 존재하지 않는 미션입니다.";
    public static final String LIMIT_PAIR_MATCH_TRY_ERROR = "[ERROR] 중복된 페어가 존재하여 매칭할 수 없습니다.";
    public static final String RETRY_INPUT_ERROR = "[ERROR] 네, 아니오만 입력해야 합니다.";

    private ErrorMessage() {
    }
}
