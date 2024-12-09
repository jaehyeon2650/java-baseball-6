package baseball.view;

import baseball.exception.ErrorMessage;
import baseball.exception.GameException;
import baseball.utils.Parser;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static List<Integer> getNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String numbers = Console.readLine().trim();
        Validator.validateGameInput(numbers);
        return Parser.splitNumbers(numbers);
    }

    public static boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine().trim();
        Validator.validateRestartInput(number);
        return Parser.getRestartResult(number);
    }

    static class Validator {
        private static void validateGameInput(String input) {
            validateLength(input);
            validateNumberType(input);
        }

        private static void validateRestartInput(String input) {
            Validator.validateNumberType(input);
            Validator.validateRestartNumberRange(input);
        }

        private static void validateLength(String input) {
            if (input.length() != 3) {
                throw GameException.from(ErrorMessage.INVALID_NUMBER_SIZE);
            }
        }

        private static void validateNumberType(String input) {
            if (!input.matches("\\d+")) {
                throw GameException.from(ErrorMessage.INVALID_NUMBER_TYPE);
            }
        }

        private static void validateRestartNumberRange(String input) {
            int number = Integer.parseInt(input);
            if (number != 1 && number != 2) {
                throw GameException.from(ErrorMessage.INVALID_RESTART_VALUE);
            }
        }
    }
}
