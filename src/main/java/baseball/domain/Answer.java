package baseball.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Answer {
    private final List<Number> numbers;

    public Answer(List<Integer> numbers) {
        Validator.validateDuplicate(numbers);
        this.numbers = numbers.stream().map(Number::new).toList();
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    static class Validator {
        private static void validateDuplicate(List<Integer> numbers) {
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            if (uniqueNumbers.size() != numbers.size()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
