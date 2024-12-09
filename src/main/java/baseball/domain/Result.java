package baseball.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public enum Result {
    BALL("볼"), STRIKE("스트라이크"), NOT("낫싱");
    private final String result;

    Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public static Map<Result, Integer> getGameResult(List<Number> answerNumbers, List<Number> inputNumbers) {
        Map<Result, Integer> results = new EnumMap<>(Result.class);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Result result = findResult(i, j, answerNumbers, inputNumbers);
                if (result == Result.STRIKE) {
                    results.put(Result.STRIKE, results.getOrDefault(Result.STRIKE, 0) + 1);
                    break;
                }
                if (result == Result.BALL) {
                    results.put(Result.BALL, results.getOrDefault(Result.BALL, 0) + 1);
                    break;
                }
            }
        }
        return results;
    }

    private static Result findResult(int answerIndex, int inputIndex, List<Number> answerNumbers,
                                     List<Number> inputNumbers) {
        if (answerIndex == inputIndex && answerNumbers.get(inputIndex).isSameNumber(inputNumbers.get(answerIndex))) {
            return Result.STRIKE;
        }
        if (answerIndex != inputIndex && answerNumbers.get(inputIndex).isSameNumber(inputNumbers.get(answerIndex))) {
            return Result.BALL;
        }
        return Result.NOT;
    }

}
