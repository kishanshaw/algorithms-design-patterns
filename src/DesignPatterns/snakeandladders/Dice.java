package DesignPatterns.snakeandladders;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int max = 6;
    private final int min = 1;
    private int diceCount;

    public Dice() {
        diceCount = 1;
    }

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int diceNumber = diceCount;
        int result = 0;
        while (diceNumber-- > 0) {
            int diceResult = ThreadLocalRandom.current().nextInt(min, max + 1);
            result += diceResult;
        }
        return result;
    }
}
