package ru.anakesh.coursera.mathematical_thinking.recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class FiveSevenCoinProblemTest {

    @Test
    void numOfCoins() {
        FiveSevenCoinProblem solver = new FiveSevenCoinProblem();
        assertDoesNotThrow(() -> {
                    for (int i = 24; i <= 1000; i++) {
                        List<Integer> coins = solver.numOfCoins(i);
                    }
                }
        );
    }
}