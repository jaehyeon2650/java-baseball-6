package baseball.utils;

import baseball.constants.GameConstant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Random {
    public static List<Integer> makeAnswer() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < GameConstant.NUMBERS_SIZE.getNumber()) {
            int randomNumber = Randoms.pickNumberInRange(GameConstant.MIN_NUMBER.getNumber(),
                    GameConstant.MAX_NUMBER.getNumber());
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
