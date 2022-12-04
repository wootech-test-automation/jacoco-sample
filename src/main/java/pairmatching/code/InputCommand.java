package pairmatching.code;

public interface InputCommand {
    String DID_NOT_EXISTS_CODE = "해당 명렁어 혹은 이름은 존재하지 않습니다.";
    String ERROR_MESSAGE = DID_NOT_EXISTS_CODE + "[input : %s]";

    static InputCommand of(final String input) {
        return null;
    }

}
