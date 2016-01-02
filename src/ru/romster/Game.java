package ru.romster;

import ru.romster.strategy.BaseStrategy;

/**
 * Created by r0m5t3r on 1/2/16.
 */
public class Game implements Runnable {

    private final int attemptCount;
    private final BaseStrategy strategy;
    private Statistic statistic;


    public Game(int attemptCount, BaseStrategy strategy) {
        if (attemptCount < 1) {
            throw new IllegalArgumentException("Attempt count should be more than 1");
        }
        this.strategy = strategy;
        this.attemptCount = attemptCount;
    }


    @Override
    public void run() {
        Statistic statistic = new Statistic();
        for (int i = 0; i < attemptCount; i++) {
            int prizeDoor = UtilsBase3.randomValue();
            Stage s = new Stage(prizeDoor);
            int selectedDoor = strategy.firstAttempt();
            int openedDoor = s.openEmptyDoor(selectedDoor);
            selectedDoor = strategy.secondAttempt(openedDoor);
            boolean sucess = selectedDoor == prizeDoor;
            statistic.addTurnResult(i, sucess);
        }
        this.statistic = statistic;
    }

    public Statistic getStatistic() {
        if (statistic == null) {
            throw new IllegalStateException("Game is not over yet");
        }
        return statistic;
    }
}
