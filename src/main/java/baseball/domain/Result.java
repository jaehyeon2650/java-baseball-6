package baseball.domain;

public enum Result {
    BALL("볼"), STRIKE("스트라이크"), NOT("낫싱");
    private final String result;

    Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
