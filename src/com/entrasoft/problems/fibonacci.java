package com.entrasoft.problems;

/**
 * Created by christopherdeschenes on 2/21/14.
 */
public class fibonacci {
    /**
     * This class calculates the fibonacci sum of the passed integer f(n) = ...
     * return 0 for n <= 1
     *
     * @param
     */

    public static void main(String[] args) {

        int[] numArray;
        numArray = new int[]{5};

        // 93 overflows a long

        int i;

        for (i = 0; i < numArray.length; i++) {
            long r = calcFibonacci(numArray[i]);
            System.out.println("Fibonacci of " + numArray[i] + ": " + r);
        }
    }


    public static long calcFibonacci(int n) {
        // Calculate fibonacci sequence for given n
        // This runs O(n**2)
        long r;
        if (n <= 0) {
            return 0;
        } else if (n <= 1) {
            return n;
        } else {
            r = calcFibonacci(n - 2) + calcFibonacci(n - 1);
        }
        return r;

    }

    // Todo Investigate the approximation ... Binet's Formula

}
