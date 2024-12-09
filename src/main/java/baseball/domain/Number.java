package baseball.domain;

import baseball.exception.ErrorMessage;
import baseball.exception.GameException;

public class Number {
    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 9;

    private final int number;

    public Number(int number) {
        Validator.validateNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isSameNumber(Number number) {
        return this.number == number.getNumber();
    }

    private static class Validator {
        private static void validateNumberRange(int number) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw GameException.from(ErrorMessage.INVALID_NUMBER_RANGE);
            }
        }
    }
}
