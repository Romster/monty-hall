package ru.romster;

import ru.romster.strategy.BaseStrategy;
import ru.romster.strategy.ImmutableStrategy;
import ru.romster.strategy.MutableStrategy;

public class Main {

    public static void main(String[] args) throws Exception{
        int iterations;
        if(args.length > 0) {
            iterations = Integer.valueOf(args[0]);
        } else {
            iterations = 1000;
        }
        System.out.println("Program is running on " + iterations + " iterations");
        BaseStrategy strategy1 = new ImmutableStrategy();
        BaseStrategy strategy2 = new MutableStrategy();
        Game immutableGame = new Game(iterations, strategy1);
        Game mutableGame = new Game(iterations, strategy2);
        Thread t1 = new Thread(immutableGame);
        Thread t2 = new Thread(mutableGame);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Statistic immutableResult = immutableGame.getStatistic();
        Statistic mutableResult = mutableGame.getStatistic();
        System.out.println("Immutable strategy success count: " + immutableResult.getSuccessTurnNums().size());
        System.out.println("Mutable strategy success count: " + mutableResult.getSuccessTurnNums().size());
    }


}
