# Coding Problem [CountIdenticalPairs](https://github.com/giannosfor/CountIdenticalPairs)

## Problem statement

Check out the [CountIdenticalPairs](https://github.com/giannosfor/CountIdenticalPairs) repository.

## Solution

The number of pairs calculation formula is not hard to deduce (see the
`UniquePairsOfIdenticalIntsCounterService` class). It turns out it's [this combination formula](https://www.hackmath.net/en/calculator/combinations-and-permutations?n=5&k=2&order=0&repeat=0).

Sorting the array allows us to only traverse it once. Java's sorting algorithm has a time complexity of `O(n*log(n))`.
Traversing the array has a time complexity of `n`, resulting in a time complexity of:
```
O(n + (n*log(n))) ~= O(n(1 + log(n)) ~= O(n*log(n))
```

Not counting input storage, the worst-case space complexity is `O(n)` when the input array contains all-identical ints.

## Potential follow-ups

The problem statement includes 
> Elements of input arrays can be modified.

It would be interesting to see if there's a solution that could reduce memory usage by 
modifying the input array in-place.

### Original problem statement

Quoted from the original problem repository:

> A zero-indexed array A consisting of N integers is given. We are
looking for pairs of elements of the array that are equal but that
occupy different positions in the array. More formally, a pair of
indices (P, Q) is called identical if 0 ≤ P < Q < N and A[P] = A[Q].
The goal is to calculate the number of identical pairs of indices.

> For example, consider array A such that:

    A[0] = 3
    A[1] = 5
    A[2] = 6
    A[3] = 3
    A[4] = 3
    A[5] = 5

> There are four pairs of identical indices: (0, 3), (0, 4), (1, 5) and
(3, 4). Note that pairs (2, 2) and (5, 1) are not counted since their
first indices are not smaller than their second.

>Write a function:

    class Solution { public int solution(int[] A); }

> that, given a zero-indexed array A of N integers, returns the
> number of identical pairs of indices.

> If the number of identical pairs of indices is greater than
1,000,000,000, the function should return 1,000,000,000.

> For example, given:
  A[0] = 3
  A[1] = 5
  A[2] = 6
  A[3] = 3
  A[4] = 3
  A[5] = 5

> the function should return 4, as explained above.

> Assume that:

> * N is an integer within the range [0..100,000];
> * each element of array A is an integer within the
  range [−1,000,000,000..1,000,000,000].

> Complexity:
> * expected worst-case time complexity is O(N*log(N));
> * expected worst-case space complexity is O(N),
  beyond input storage (not counting the storage
  required for input arguments).

> Elements of input arrays can be modified.
