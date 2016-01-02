package ru.romster.strategy;

/**
 * Created by r0m5t3r on 1/2/16.
 */
public class ImmutableStrategy extends BaseStrategy {

    @Override
    protected int chooseSecondTime(int openedDoor) {
        return selectedDoor;
    }
}
