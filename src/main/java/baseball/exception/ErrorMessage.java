package baseball.exception;

public enum ErrorMessage {
    INVALID_NUMBER_SIZE("숫자는 3개여야합니다."),
    INVALID_NUMBER_DUPLICATE("숫자는 중복되면 안됩니다."),
    INVALID_NUMBER_TYPE("숫자만 입력해야합니다"),
    INVALID_NUMBER_RANGE("숫자는 1부터 9사이의 숫자여야합니다."),
    INVALID_RESTART_VALUE("1 또는 2만 입력가능합니다");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
