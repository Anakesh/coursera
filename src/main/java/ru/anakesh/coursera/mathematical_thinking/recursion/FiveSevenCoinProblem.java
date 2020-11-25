package ru.anakesh.coursera.mathematical_thinking.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiveSevenCoinProblem {

    public List<Integer> numOfCoins(int sum) {
        if (sum < 24) return null;
        return recursiveChange(sum);
    }

    private List<Integer> recursiveChange(int amount) {
        switch (amount) {
            case 24:
                return new ArrayList<>(Arrays.asList(5, 5, 7, 7));
            case 25:
                return new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5));
            case 26:
                return new ArrayList<>(Arrays.asList(5, 7, 7, 7));
            case 27:
                return new ArrayList<>(Arrays.asList(5, 5, 5, 5, 7));
            case 28:
                return new ArrayList<>(Arrays.asList(7, 7, 7, 7));
            default:
                List<Integer> r = recursiveChange(amount - 5);
                r.add(5);
                return r;
        }
    }
}
