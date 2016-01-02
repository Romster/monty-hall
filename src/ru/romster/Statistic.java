package ru.romster;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by r0m5t3r on 1/2/16.
 */
public class Statistic {
    private Map<Integer, Boolean> turnResults = new TreeMap<>();


    public void addTurnResult(int turnNum, boolean success) {
        turnResults.put(turnNum, success);
    }

    public List<Integer> getSuccessTurnNums() {
        List<Integer> list = turnResults.entrySet().stream()
                .filter(v -> v.getValue())
                .map(v -> v.getKey())
                .collect(Collectors.toList());
        return list;
    }
}
