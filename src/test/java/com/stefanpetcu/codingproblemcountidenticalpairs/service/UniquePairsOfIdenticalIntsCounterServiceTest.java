package com.stefanpetcu.codingproblemcountidenticalpairs.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UniquePairsOfIdenticalIntsCounterServiceTest {
    private static final int REALLY_BIG_ARRAY_SIZE = 10_000_000; // Any order of magnitude larger crashes the program.
    private final UniquePairsOfIdenticalIntsCounterService subject = new UniquePairsOfIdenticalIntsCounterService();

    private static int[] nonUniformArrayWithNumberOfPairsExceedingMaxSupported() {
        var arr = new int[85000];

        Arrays.fill(arr,
                10001,
                30002,
                1);
        Arrays.fill(arr,
                30003,
                60004,
                2);
        Arrays.fill(arr,
                60005,
                85000,
                3);

        return arr;
    }

    private static Stream<Arguments> intArraysProvider() {
        return Stream.of(
                Arguments.of(new int[]{}, 0, "Empty arrays have 0 pairs."),
                Arguments.of(new int[]{0}, 0, "Arrays with 1 element have 0 pairs."),
                Arguments.of(new int[]{1, 1}, 1, "Arrays with 2 elements have 0 pairs."),
                Arguments.of(new int[]{3, 5, 6, 3, 3, 5}, 4, "Array has 4 pairs."),
                Arguments.of(new int[]{-1, 3, 5, -10, 6, 3, 3, 5, -1, 5, 3, -10, 3, -1, 5, -10},
                        22,
                        "Array should have 2 pairs."),
                Arguments.of(new int[REALLY_BIG_ARRAY_SIZE], // An array filled with 0s.
                        1_000_000_000,
                        "Function must return 1000000000 for arrays exceeding the maximum count of identical ints."),
                Arguments.of(nonUniformArrayWithNumberOfPairsExceedingMaxSupported(),
                        1_000_000_000,
                        "Function must return 1000000000 for arrays exceeding the maximum number of pairs.")
        );
    }

    @ParameterizedTest
    @MethodSource("intArraysProvider")
    void count_returnsNumberOfUniquePairsOfIdenticalNumbers_givenANonEmptyArrayOfInts(int[] input,
            int expectedResult, String message) {
        assertEquals(expectedResult, subject.count(input), message);
    }
}
