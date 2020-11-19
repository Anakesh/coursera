package ru.anakesh.coursera.mathematical_thinking.diagonals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DiagonalsTest {

    @Test
    void placeDiagonals() {
        Diagonals diagonals = new Diagonals(6);
        String[][] field = diagonals.placeDiagonals(22);
        assertNotNull(field);
        for (String[] strings : field) {
            System.out.println(Arrays.toString(strings));
        }
    }
}