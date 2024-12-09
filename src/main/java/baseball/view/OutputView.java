package baseball.view;

import baseball.constants.GameConstant;
import baseball.domain.Result;
import java.util.Map;

public class OutputView {
    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printResult(Map<Result, Integer> results) {
        StringBuilder builder = new StringBuilder();
        int ballCount = results.getOrDefault(Result.BALL, 0);
        int strikeCount = results.getOrDefault(Result.STRIKE, 0);
        saveResult(builder, ballCount, strikeCount);
        System.out.println(builder);
        if (strikeCount == GameConstant.NUMBERS_SIZE.getNumber()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static void saveResult(StringBuilder builder, int ballCount, int strikeCount) {
        checkNothing(builder, ballCount, strikeCount);
        checkBall(builder, ballCount);
        checkStrike(builder, strikeCount);
    }

    private static void checkNothing(StringBuilder builder, int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            builder.append(Result.NOT.getResult());
        }
    }

    private static void checkStrike(StringBuilder builder, int strikeCount) {
        if (strikeCount != 0) {
            builder.append(strikeCount).append(Result.STRIKE.getResult());
        }
    }

    private static void checkBall(StringBuilder builder, int ballCount) {
        if (ballCount != 0) {
            builder.append(ballCount).append(Result.BALL.getResult()).append(" ");
        }
    }
}
