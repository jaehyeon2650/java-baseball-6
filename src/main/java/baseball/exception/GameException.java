package baseball.exception;

public class GameException extends IllegalArgumentException {
    private GameException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static GameException from(ErrorMessage errorMessage) {
        return new GameException(errorMessage);
    }
}
