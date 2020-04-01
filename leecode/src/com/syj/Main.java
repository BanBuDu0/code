package com.syj;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    static class Solution {
        public int longestPalindrome(String s) {
            int[] count = new int[128];
            char[] c = s.toCharArray();
            for (char i : c) {
                count[i - 'A']++;
            }
            int odd = 0, res = 0;
            for (int i = 0; i < 128; ++i) {
                if (count[i] % 2 == 0) {
                    res += count[i];
                }
                if (count[i] % 2 == 1) {
                    res += (count[i] - 1);
                    odd = 1;
                }
            }
            return odd + res;
        }

        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            if (k >= arr.length) {
                return arr;
            }
            Arrays.sort(arr);
            return Arrays.copyOf(arr, k);
        }


    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.getLeastNumbers());

    }
}
