package baseball.domain;

import baseball.constants.GameConstant;
import baseball.exception.ErrorMessage;
import baseball.exception.GameException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Computer {
    private final List<Number> numbers;

    public Computer(List<Integer> numbers) {
        Validator.validateComputerNumber(numbers);
        this.numbers = numbers.stream().map(Number::new).toList();
    }

    public Map<Result, Integer> getGameResults(List<Number> inputNumbers) {
        return Result.getGameResult(this.numbers, inputNumbers);
    }

    static class Validator {
        private static void validateComputerNumber(List<Integer> numbers) {
            validateNumbersSize(numbers);
            validateDuplicate(numbers);
        }

        private static void validateNumbersSize(List<Integer> numbers) {
            if (numbers.size() != GameConstant.NUMBERS_SIZE.getNumber()) {
                throw GameException.from(ErrorMessage.INVALID_NUMBER_SIZE);
            }
        }

        private static void validateDuplicate(List<Integer> numbers) {
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            if (uniqueNumbers.size() != numbers.size()) {
                throw GameException.from(ErrorMessage.INVALID_NUMBER_DUPLICATE);
            }
        }
    }
}
