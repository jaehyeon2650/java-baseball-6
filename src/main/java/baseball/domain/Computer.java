package baseball.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Computer {
    private final List<Number> numbers;

    public Computer(List<Integer> numbers) {
        this.numbers = numbers.stream().map(Number::new).toList();

    }

    public Map<Result, Integer> getGameResults(List<Number> inputNumbers) {
        Map<Result, Integer> result = new EnumMap<>(Result.class);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && numbers.get(j).isSameNumber(inputNumbers.get(i))) {
                    result.put(Result.STRIKE, result.getOrDefault(Result.STRIKE, 0) + 1);
                    break;
                }
                if (i != j && numbers.get(j).isSameNumber(inputNumbers.get(i))) {
                    result.put(Result.BALL, result.getOrDefault(Result.BALL, 0) + 1);
                    break;
                }
            }
        }
        if (result.getOrDefault(Result.STRIKE, 0) == 0 && result.getOrDefault(Result.BALL, 0) == 0) {
            result.put(Result.NOT, 1);
        }
        return result;
    }

}
