package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberTest {

    @ParameterizedTest
    @CsvSource({"10", "0", "-1"})
    @DisplayName("1부터 9사이의 숫자가 아닌 경우 예외가 발생한다.")
    void invalidNumberRange(int number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("만약 숫자가 같다면 true를 반환한다.")
    void isSameNumber_true() {
        // given
        Number number1 = new Number(1);
        Number number2 = new Number(1);
        // when
        boolean sameNumber = number1.isSameNumber(number2);
        // then
        assertThat(sameNumber).isTrue();
    }

    @Test
    @DisplayName("만약 숫자가 다르다면 false를 반환한다.")
    void isSameNumber_false() {
        // given
        Number number1 = new Number(1);
        Number number2 = new Number(2);
        // when
        boolean sameNumber = number1.isSameNumber(number2);
        // then
        assertThat(sameNumber).isFalse();
    }
}