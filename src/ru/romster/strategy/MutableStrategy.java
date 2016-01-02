package ru.romster.strategy;

import ru.romster.UtilsBase3;

/**
 * Created by r0m5t3r on 1/2/16.
 */
public class MutableStrategy extends BaseStrategy {
    @Override
    protected int chooseSecondTime(int openedDoor) {
        return UtilsBase3.getMissingValue(openedDoor, selectedDoor);
    }
}
