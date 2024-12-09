package baseball.constants;

public enum GameConstant {
    NUMBERS_SIZE(3),
    MIN_NUMBER(1),
    MAX_NUMBER(9),
    RESTART_TRUE(1),
    RESTART_FALSE(2);
    private final Integer number;

    GameConstant(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
