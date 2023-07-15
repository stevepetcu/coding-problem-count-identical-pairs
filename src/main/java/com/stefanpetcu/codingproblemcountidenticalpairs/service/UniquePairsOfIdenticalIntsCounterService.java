package com.stefanpetcu.codingproblemcountidenticalpairs.service;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePairsOfIdenticalIntsCounterService {
    private static final int MAX_SUPPORTED_NUMBER_OF_PAIRS_COUNT = 1_000_000_000;
    // Any list of identical ints that's got more than IDENTICAL_INTS_LIST_UPPER_SIZE_THRESHOLD elements
    // will have over MAX_SUPPORTED_NUMBER_OF_PAIRS_COUNT pairs. We can return early without parsing the
    // remaining inputs or even calculating the number of pairs. Cheats!
    private static final int IDENTICAL_INTS_LIST_UPPER_SIZE_THRESHOLD = 44721;
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
                if (identicalIntsList.size() > IDENTICAL_INTS_LIST_UPPER_SIZE_THRESHOLD) {
                    return MAX_SUPPORTED_NUMBER_OF_PAIRS_COUNT;
                }
                if (arr[i] != identicalIntsList.get(0) || i == arr.length - 1) {
                    pairCount += calculateCombinations(identicalIntsList);

                    if (pairCount >= MAX_SUPPORTED_NUMBER_OF_PAIRS_COUNT) {
                        return MAX_SUPPORTED_NUMBER_OF_PAIRS_COUNT;
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
