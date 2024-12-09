package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.exception.ErrorMessage;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AnswerTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("숫자가 3개가 아니면 예외가 발생한다.")
    void invalidNumberSize(List<Integer> numbers) {
        assertThatThrownBy(() -> new Answer(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_SIZE.getMessage());
    }

    private static Stream<Arguments> invalidNumberSize() {
        return Stream.of(
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3, 4)),
                Arguments.of(List.of(1, 2, 3, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("중복된 숫자가 있으면 예외가 발생한다.")
    void invalidNumberDuplicate(List<Integer> numbers) {
        assertThatThrownBy(() -> new Answer(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_DUPLICATE.getMessage());
    }

    private static Stream<Arguments> invalidNumberDuplicate() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 2)),
                Arguments.of(List.of(1, 1, 1)),
                Arguments.of(List.of(1, 2, 2))
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("1부터 9사이의 숫자가 아닌 경우 예외가 발생한다.")
    void invalidNumberRange(List<Integer> numbers) {
        assertThatThrownBy(() -> new Answer(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
    }

    private static Stream<Arguments> invalidNumberRange() {
        return Stream.of(
                Arguments.of(List.of(1, 10, 2)),
                Arguments.of(List.of(1, 11, 10)),
                Arguments.of(List.of(1, -10, 2)),
                Arguments.of(List.of(1, 0, 2))
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("정상적인 입력에서는 Answer가 정상적으로 생성된다.")
    void successMakeAnswer(List<Integer> numbers) {
        Answer answer = new Answer(numbers);
    }

    private static Stream<Arguments> successMakeAnswer() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(1, 2, 4)),
                Arguments.of(List.of(1, 9, 2)),
                Arguments.of(List.of(1, 4, 2))
        );
    }
}