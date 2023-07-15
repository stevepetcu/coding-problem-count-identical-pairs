package com.stefanpetcu.codingproblemcountidenticalpairs.service;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePairsOfIdenticalIntsCounterService {
    public int count(int[] arr) {
        Arrays.sort(arr);

        var pairs = new ArrayList<Integer>();
        int pairCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (pairs.size() == 0) {
                pairs.add(arr[i]);
            } else {
                if (arr[i] == pairs.get(0)) {
                    pairs.add(arr[i]);
                }
                if (arr[i] != pairs.get(0) || i == arr.length - 1) {
                    pairCount += calculateCombinations(pairs);

                    if (pairCount >= 1_000_000_000) {
                        return 1_000_000_000;
                    }

                    pairs.clear();
                    pairs.add(arr[i]);
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
