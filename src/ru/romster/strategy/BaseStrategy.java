package ru.romster.strategy;

import ru.romster.UtilsBase3;

/**
 * Created by r0m5t3r on 1/2/16.
 */
public abstract class BaseStrategy {
    protected int selectedDoor = -1;

    public final int firstAttempt() {
        selectedDoor = chooseFirstTime();
        return selectedDoor;
    }

    public final int secondAttempt(int openedDoor) {
        selectedDoor = chooseSecondTime(openedDoor);
        return selectedDoor;
    }

    private int chooseFirstTime() {
        return UtilsBase3.randomValue();
    }

    protected abstract int chooseSecondTime(int openedDoor);

}
