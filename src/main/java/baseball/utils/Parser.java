package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Integer> splitNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int number = Integer.parseInt(String.valueOf(input.charAt(i)));
            numbers.add(number);
        }
        return numbers;
    }

    public static boolean getRestartResult(String input) {
        int result = Integer.parseInt(input);
        return result == 1;
    }
}
