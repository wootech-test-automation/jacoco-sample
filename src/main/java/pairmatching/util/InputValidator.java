package pairmatching.util;

import pairmatching.message.ErrorMessage;

public class InputValidator {

    public static final String PAIR_MATCHING = "1";
    public static final String PAIR_VIEW = "2";
    public static final String PAIR_RESET = "3";
    public static final String QUIT = "Q";

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
}
