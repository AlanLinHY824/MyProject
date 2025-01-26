package com.alan.math;

import java.util.ArrayList;

/**
 * @author linhyanyu
 * @description
 * @since 2024/11/26
 */
public class RecursionTest {

    private static final int[] rewards = {1, 2, 5, 10};

    public static void main(String[] args) {
        getReward(10, new ArrayList<>());
        System.out.println("-------");
        getMultiPossible(8, new ArrayList<>());
    }

    private static void getReward(int n, ArrayList<Integer> result) {
        if (n == 0) {
            System.out.println(result);
        } else if (n < 0) {
            return;
        } else {
            for (int i = 0; i < rewards.length; i++) {
                ArrayList<Integer> newResult = (ArrayList<Integer>) (result.clone());
                newResult.add(rewards[i]);
                getReward(n - rewards[i], newResult);
            }

        }

    }

    private static void getMultiPossible(int n, ArrayList<Integer> result) {
        if (n == 1) {
            if (!result.contains(1)){
                result.add(1);
            }
            System.out.println(result);
            return;
        } else if (n < 1) {
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> newResult = (ArrayList<Integer>) (result.clone());
                 if (n % i != 0) {
                    continue;
                }
                if (i == 1 && newResult.contains(1)) {
                    newResult.add(n);
                    System.out.println(newResult);
                    continue;
                }
                newResult.add(i);
                getMultiPossible(n / i, newResult);
            }

        }

    }


}
