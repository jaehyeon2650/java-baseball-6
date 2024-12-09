package baseball.view;

import baseball.utils.Parser;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static List<Integer> getNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String numbers = Console.readLine().trim();
        Validator.validateGameInput(numbers);
        return Parser.splitNumber(numbers);
    }

    private static class Validator {
        private static void validateGameInput(String input) {
            validateLength(input);
            validateNumber(input);
        }

        private static void validateLength(String input) {
            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }
        }

        private static void validateNumber(String input) {
            validateNumberRange(input);
            validateNumberType(input);
        }

        private static void validateNumberType(String input) {
            if (!input.matches("\\d+")) {
                throw new IllegalArgumentException();
            }
        }

        private static void validateNumberRange(String input) {
            try {
                for (int i = 0; i < input.length(); i++) {
                    int number = Integer.parseInt(String.valueOf(input.charAt(i)));
                    if (number <= 0 || number > 9) {
                        throw new IllegalArgumentException();
                    }
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }
}
