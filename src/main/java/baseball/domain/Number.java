package baseball.domain;

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
            if (number <= 0 || number > 9) {
                throw new IllegalArgumentException();
            }
        }
    }
}
