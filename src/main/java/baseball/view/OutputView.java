package baseball.view;

import baseball.domain.Result;
import java.util.Map;

public class OutputView {
    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printResult(Map<Result, Integer> results) {
        StringBuilder builder = new StringBuilder();
        if (results.getOrDefault(Result.NOT, 0) == 1) {
            builder.append(Result.NOT.getResult());
        }
        int ballCount = results.getOrDefault(Result.BALL, 0);
        int strikeCount = results.getOrDefault(Result.STRIKE, 0);
        if (ballCount != 0) {
            builder.append(ballCount).append(Result.BALL.getResult()).append(" ");
        }
        if (strikeCount != 0) {
            builder.append(strikeCount).append(Result.STRIKE.getResult());
        }
        System.out.println(builder);
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
