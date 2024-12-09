package baseball.domain;

import baseball.constants.GameConstant;
import baseball.exception.ErrorMessage;
import baseball.exception.GameException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Answer {
    private final List<Number> numbers;

    public Answer(List<Integer> numbers) {
        Validator.validateAnswerNumber(numbers);
        this.numbers = numbers.stream().map(Number::new).toList();
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private static class Validator {
        private static void validateAnswerNumber(List<Integer> numbers) {
            validateNumbersSize(numbers);
            validateDuplicate(numbers);
        }

        private static void validateDuplicate(List<Integer> numbers) {
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            if (uniqueNumbers.size() != numbers.size()) {
                throw GameException.from(ErrorMessage.INVALID_NUMBER_DUPLICATE);
            }
        }

        private static void validateNumbersSize(List<Integer> numbers) {
            if (numbers.size() != GameConstant.NUMBERS_SIZE.getNumber()) {
                throw GameException.from(ErrorMessage.INVALID_NUMBER_SIZE);
            }
        }
    }
}
