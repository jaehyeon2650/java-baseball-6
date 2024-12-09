package baseball.controller;

import baseball.domain.Answer;
import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.utils.Random;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.Map;

public class GameController {
    private Computer computer;

    public void gameStart() {
        OutputView.gameStart();
        do {
            computer = new Computer(Random.makeAnswer());
            game();
        } while (InputView.restart());
    }

    private void game() {
        while (true) {
            List<Integer> numbers = InputView.getNumbers();
            Answer answer = new Answer(numbers);
            Map<Result, Integer> gameResults = computer.getGameResults(answer.getNumbers());
            OutputView.printResult(gameResults);
            if (gameResults.getOrDefault(Result.STRIKE, 0) == 3) {
                return;
            }
        }
    }
}
