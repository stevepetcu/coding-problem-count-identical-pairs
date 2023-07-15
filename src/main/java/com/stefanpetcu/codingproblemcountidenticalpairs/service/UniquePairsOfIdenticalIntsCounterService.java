package com.stefanpetcu.codingproblemcountidenticalpairs.service;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePairsOfIdenticalIntsCounterService {
    // Any list of identical ints that's got more than MAX_COUNT_IDENTICAL_INTS elements
    // will have > MAX_COUNT_NUMBER_OF_PAIRS pairs. We can return early w/o parsing the
    // remaining inputs or even calculating the number of pairs. Cheats!
    private static final int MAX_COUNT_IDENTICAL_INTS = 44721;
    private static final int MAX_COUNT_NUMBER_OF_PAIRS = 1_000_000_000;

    public int count(int[] arr) {
        Arrays.sort(arr);

        var identicalIntsList = new ArrayList<Integer>();
        int pairCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (identicalIntsList.size() == 0) {
                identicalIntsList.add(arr[i]);
            } else {
                if (arr[i] == identicalIntsList.get(0)) {
                    identicalIntsList.add(arr[i]);
                }
                if (identicalIntsList.size() > MAX_COUNT_IDENTICAL_INTS) {
                    return MAX_COUNT_NUMBER_OF_PAIRS;
                }
                if (arr[i] != identicalIntsList.get(0) || i == arr.length - 1) {
                    pairCount += calculateCombinations(identicalIntsList);

                    if (pairCount >= MAX_COUNT_NUMBER_OF_PAIRS) {
                        return MAX_COUNT_NUMBER_OF_PAIRS;
                    }

                    identicalIntsList.clear();
                    identicalIntsList.add(arr[i]);
                }
            }
        }

        return pairCount;
    }

    private int calculateCombinations(ArrayList<Integer> arr) {
//        [1, 1] = 1        formula = (2 * (2 - 1)) / 2 = 1
//        [1, 1, 1] = 3     formula = (3 * (3 -1 )) / 2 = 3
//        [1, 1, 1, 1] = 6  formula = (4 * (4 - 1)) / 2 = 6
//        Generalised formula = (elCount * (elCount - 1)) / pairCount
        return (arr.size() * (arr.size() - 1)) / 2;
    }
}
