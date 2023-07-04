package DesignPatterns.statedesign;

public enum Coin {
    FIVE(5),
    TEN(10),

    TWENTY(20),

    SEVENTY_FIVE(75);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
