package baseball.domain;

import baseball.constants.GameConstant;
import baseball.exception.ErrorMessage;
import baseball.exception.GameException;
import java.util.List;
import java.util.Map;

public class Computer {
    private final List<Number> numbers;

    public Computer(List<Integer> numbers) {
        Validator.validateNumbersSize(numbers);
        this.numbers = numbers.stream().map(Number::new).toList();
    }

    public Map<Result, Integer> getGameResults(List<Number> inputNumbers) {
        return Result.getGameResult(this.numbers, inputNumbers);
    }

    static class Validator {
        private static void validateNumbersSize(List<Integer> numbers) {
            if (numbers.size() != GameConstant.NUMBERS_SIZE.getNumber()) {
                throw GameException.from(ErrorMessage.INVALID_NUMBER_SIZE);
            }
        }
    }
}
