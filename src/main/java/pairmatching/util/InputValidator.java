package pairmatching.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.message.ErrorMessage;

public class InputValidator {
    public static final String PAIR_MATCHING = "1";
    public static final String PAIR_VIEW = "2";
    public static final String PAIR_RESET = "3";
    public static final String QUIT = "Q";
    public static final String SEPARATOR = ", ";
    public static final int NEED_SIZE_INPUT = 3;
    public static final String YES = "네";
    public static final String NO = "아니오";

    private InputValidator() {
    }

    public static String validateSelectMenu(final String userInput) {
        if (!userInput.equals(PAIR_MATCHING)
                && !userInput.equals(PAIR_VIEW)
                && !userInput.equals(PAIR_RESET)
                && !userInput.equals(QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.MENU_SELECT_ERROR);
        }
        return userInput;
    }

    public static List<String> validateCourseInformation(final String userInput) {
        if (userInput.split(SEPARATOR).length != NEED_SIZE_INPUT) {
            throw new IllegalArgumentException(ErrorMessage.COURSE_INFORMATION_ERROR);
        }
        return Arrays.stream(userInput.split(SEPARATOR))
                .collect(Collectors.toList());
    }

    public static String validateRetryInput(final String userInput) {
        if (!userInput.equals(YES) && !userInput.equals(NO)) {
            throw new IllegalArgumentException(ErrorMessage.RETRY_INPUT_ERROR);
        }
        return userInput;
    }
}
