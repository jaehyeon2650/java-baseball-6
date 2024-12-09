package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("정상적으로 결과값을 도출해야한다.")
    void getResult(List<Integer> numbers, int expectedStrike, int expectedBall) {
        // given
        List<Integer> answer = List.of(1, 2, 3);
        List<Number> answerList = answer.stream().map(Number::new).toList();
        List<Number> numberList = numbers.stream().map(Number::new).toList();
        // when
        Map<Result, Integer> gameResults = Result.getGameResult(answerList, numberList);
        Integer strike = gameResults.getOrDefault(Result.STRIKE, 0);
        Integer ball = gameResults.getOrDefault(Result.BALL, 0);
        // then
        assertThat(strike).isEqualTo(expectedStrike);
        assertThat(ball).isEqualTo(expectedBall);
    }

    private static Stream<Arguments> getResult() {
        return Stream.of(
                Arguments.of(List.of(3, 2, 1), 1, 2),
                Arguments.of(List.of(1, 2, 4), 2, 0),
                Arguments.of(List.of(1, 9, 2), 1, 1),
                Arguments.of(List.of(3, 1, 2), 0, 3),
                Arguments.of(List.of(4, 5, 6), 0, 0)
        );
    }
}