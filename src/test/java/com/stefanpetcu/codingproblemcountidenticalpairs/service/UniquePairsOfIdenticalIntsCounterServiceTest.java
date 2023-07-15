package com.stefanpetcu.codingproblemcountidenticalpairs.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UniquePairsOfIdenticalIntsCounterServiceTest {
    private static final int REALLY_BIG_ARRAY_SIZE = 10000000; // Any order of mag larger crashes the program.
    private final UniquePairsOfIdenticalIntsCounterService subject = new UniquePairsOfIdenticalIntsCounterService();

    private static Stream<Arguments> intArraysProvider() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{3, 5, 6, 3, 3, 5}, 4),
                Arguments.of(new int[]{-1, 3, 5, -10, 6, 3, 3, 5, -1, 5, 3, -10, 3, -1, 5, -10}, 22),
                Arguments.of(new int[REALLY_BIG_ARRAY_SIZE], 1_000_000_000) // An array filled with 0s.
        );
    }

    @ParameterizedTest
    @MethodSource("intArraysProvider")
    void count_returnsNumberOfUniquePairsOfIdenticalNumbers_givenANonEmptyArrayOfInts(int[] input, int expectedResult) {
        assertEquals(expectedResult, subject.count(input));
    }
}
