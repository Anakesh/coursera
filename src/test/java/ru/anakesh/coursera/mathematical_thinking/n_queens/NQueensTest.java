package ru.anakesh.coursera.mathematical_thinking.n_queens;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NQueensTest {
    NQueens nQueens = new NQueens();

    @Test
    void findSolution() {
        int n = 20;
        int[] it = nQueens.findSolution(n);
        assertNotNull(it);
        assertEquals(n, it.length);
        assertEquals(n, Arrays.stream(it).distinct().count());
        System.out.println(Arrays.toString(it));
    }
}