package baseball.domain;

import baseball.constants.GameConstant;
import baseball.exception.ErrorMessage;
import baseball.exception.GameException;

public class Number {
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
            if (number < GameConstant.MIN_NUMBER.getNumber() || number > GameConstant.MAX_NUMBER.getNumber()) {
                throw GameException.from(ErrorMessage.INVALID_NUMBER_RANGE);
            }
        }
    }
}
