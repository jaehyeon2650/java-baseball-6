package baseball.domain;

import java.util.Collections;
import java.util.List;

public class Answer {
    private final List<Number> numbers;

    public Answer(List<Integer> numbers) {
        this.numbers = numbers.stream().map(Number::new).toList();

    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
