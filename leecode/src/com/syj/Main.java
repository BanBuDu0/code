package com.syj;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

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

        /**
         * 718. 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 中等 输入： A: [1,2,3,2,1] B:
         * [3,2,1,4,7] 输出：3 动态规划题 dp[i][j]为以A[i-1],B[j-1]结尾的最长子数组， dp[i][j] = dp[i -
         * 1][j - 1] + 1 if A[i - 1] == B[j - 1] else 0
         *
         * @param A 数组A
         * @param B 数组B
         * @return 最长重复子数组
         */
        public int findLength(int[] A, int[] B) {
            int maxLength = 0;
            int[][] dp = new int[A.length + 1][B.length + 1];
            for (int i = 1; i <= A.length; ++i) {
                for (int j = 1; j <= B.length; ++j) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        maxLength = dp[i][j] > maxLength ? dp[i][j] : maxLength;
                    }
                }
            }
            return maxLength;
        }

        /**
         * 378. 有序矩阵中第K小的元素 中等 使用归并排序解 归并n个数组，n=matrix的行数 其中使用优先队列维护一个容量为n的小顶堆 小顶堆中的数组，
         * 0-值，1-值所在的行，2-值所在列
         *
         * @param matrix matrix
         * @param k      k
         * @return 有序矩阵中第K小的元素
         */
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                pq.offer(new int[]{matrix[i][0], i, 0});
            }
            for (int i = 0; i < k - 1; i++) {
                int[] now = pq.poll();
                if (now[2] != n - 1) {
                    pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
                }
            }
            return pq.poll()[0];
        }

        /**
         * 108. 将有序数组转换为二叉搜索树 递归求解
         *
         * @param nums nums
         * @return 二叉搜索树
         */
        public TreeNode sortedArrayToBST(int[] nums) {
            int len = nums.length;
            return ass(0, len - 1, nums);
        }

        public TreeNode ass(int left, int right, int[] nums) {
            if (left > right) {
                return null;
            }
            int middle = (left + right) / 2;
            TreeNode root = new TreeNode(nums[middle]);
            root.left = ass(left, middle - 1, nums);
            root.right = ass(middle + 1, right, nums);
            return root;
        }

        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        /**
         * 32. 最长有效括号
         *
         * @param s string
         * @return length
         */
        public int longestValidParentheses(String s) {
            int[] dp = new int[s.length()];
            int res = 0;
            for (int i = 1; i < s.length(); ++i) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    if (dp[i] > res) {
                        res = dp[i];
                    }
                }
            }
            return res;
        }

        /**
         * 63. 不同路径 II
         *
         * @param obstacleGrid
         * @return
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            for (int i = 1; i < m; ++i) {
                if (obstacleGrid[i][0] == 1) {
                    dp[i][0] = 0;
                    break;
                } else {
                    dp[i][0] = dp[i - 1][0];
                }
            }
            for (int i = 1; i < n; ++i) {
                if (obstacleGrid[0][i] == 1) {
                    dp[0][i] = 0;
                    break;
                } else {
                    dp[0][i] = dp[0][i - 1];
                }
            }

            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }

        /**
         * 112. 路径总和
         *
         * @param root
         * @param sum
         * @return
         */
        public boolean hasPathSum(TreeNode root, int sum) {
            if (null == root) {
                return false;
            }
            Queue<TreeNode> treeNodeQueue = new LinkedList<>();
            Queue<Integer> nodeValQueue = new LinkedList<>();
            treeNodeQueue.offer(root);
            nodeValQueue.offer(root.val);
            while (!treeNodeQueue.isEmpty()) {
                TreeNode treeNode = treeNodeQueue.poll();
                int val = nodeValQueue.poll();
                if (null != treeNode.left) {
                    treeNodeQueue.offer(treeNode.left);
                    nodeValQueue.offer(treeNode.left.val + val);
                }
                if (null != treeNode.right) {
                    treeNodeQueue.offer(treeNode.right);
                    nodeValQueue.offer(treeNode.right.val + val);
                }
                if (null == treeNode.right && null == treeNode.left) {
                    if (val == sum) {
                        return true;
                    }
                    continue;
                }

            }
            return false;
        }

        /**
         * ByteDance 无重复字符的最长子串 滑动窗口思想 使用count记录字符最后一次出现的位置
         *
         * @param s S
         * @return int
         */
        public int lengthOfLongestSubstring(String s) {
            int[] count = new int[256];
            int left = 0, right = 0, res = 0;
            for (; right < s.length(); ++right) {
                left = Math.max(count[s.charAt(right)], left);
                res = Math.max(right - left + 1, res);
                count[s.charAt(right)] = right + 1;
            }
            return res;
        }

        /**
         * 面试题 16.11. 跳水板
         *
         * @param shorter
         * @param longer
         * @param k
         * @return
         */
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0) {
                return new int[0];
            }

            if (shorter == longer) {
                return new int[]{longer * k};
            }
            int[] res = new int[k + 1];
            for (int i = 0; i <= k; ++i) {
                // res.append(short * i + longer *(k - i));
                res[i] = shorter * (k - i) + longer * i;
            }
            return res;
        }

        /**
         * ByteDance
         *
         * @param strs strs
         * @return string
         */
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            int len = strs.length;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < strs[0].length(); ++i) {
                char t = strs[0].charAt(i);
                for (int j = 1; j < len; ++j) {
                    if (i >= strs[j].length() || strs[j].charAt(i) != t) {
                        return res.toString();
                    }
                }
                res.append(t);
            }
            return res.toString();
        }

        /**
         * 面试题 17.13. 恢复空格 没做出来。。。
         *
         * @param dictionary d
         * @param sentence   s
         * @return int
         */
        public int respace(String[] dictionary, String sentence) {
            int n = sentence.length();
            int m = dictionary.length;
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1];
                for (int j = 0; j < m; j++) {
                    if (i < dictionary[j].length())
                        continue;
                    if (sentence.startsWith(dictionary[j], i - dictionary[j].length())) {
                        dp[i] = Math.max(dp[i - dictionary[j].length()] + dictionary[j].length(), dp[i]);
                    }
                }
            }
            return n - dp[n];
        }

        /**
         * dp[i] 表示第i天结束的时候累计最大收益，且有3种不同的状态
         * 1. dp[i][0] 持有一直股票
         * 2. dp[i][1] 不持有股票且处于冷冻期
         * 3. dp[i][2] 不持有股票且不处于冷冻期
         */
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int res = 0;
            int len = prices.length;
            int[][] dp = new int[len][3];
            dp[0][0] = -prices[0];
            for (int i = 1; i < len; ++i) {
                //dp[i - 1][0]表示该股票为i-1天就持有的，dp[i - 1][2] - prices[i]表示第i天新买入的股票
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                //dp[i][1] 表示不持有股票且处于冷冻期，说明第i天卖掉了股票
                //其最大收益 = i - 1天持有股票的最大收益 + 当天卖出股票的收益
                dp[i][1] = dp[i - 1][0] + prices[i];
                //dp[i][2]表示不持有股票且不处于冷冻期，说明第i天没有操作
                //最大收益 = i-1天的时候处于冷冻期或不处于冷冻期
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }
            return Math.max(dp[len - 1][1], dp[len - 1][2]);
        }

        /**
         * 174. 地下城游戏
         * 设dp[i][j]为i，j到终点所需的最小距离
         * 这道题正向dp会出错，因为正向dp没有满足无后效性
         *
         * @param dungeon dungeon
         * @return int
         */
        public int calculateMinimumHP(int[][] dungeon) {
            int n = dungeon.length, m = dungeon[0].length;
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i <= n; ++i) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[n][m - 1] = dp[n - 1][m] = 1;
            for (int i = n - 1; i >= 0; --i) {
                for (int j = m - 1; j >= 0; --j) {
                    int temp = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(temp - dungeon[i][j], 1);
                }
            }
            return dp[0][0];
        }


        /**
         * 51. N 皇后
         * 经典回溯求解
         */
        public List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            List<Integer> road = new ArrayList<>();
            backtrack(road, n, 0);
            return result;
        }

        /**
         * 根据  road 画出棋盘
         *
         * @param road 保持皇后所在列，列的index就是皇后所在行
         * @param n    期盼大小
         */
        public void addToResult(List<Integer> road, int n) {
            List<String> tempString = new ArrayList<>();
            for (int row = 0; row < n; ++row) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int column = 0; column < n; ++column) {
                    if (column == road.get(row)) {
                        stringBuilder.append('Q');
                    } else {
                        stringBuilder.append('.');
                    }
                }
                tempString.add(stringBuilder.toString());
            }
            result.add(tempString);
            System.out.println(tempString);
        }

        /**
         * 判断传入的row和column这个位置能不能放皇后
         *
         * @param road   road
         * @param row    row
         * @param column column
         * @param n      n
         * @return bool
         */
        public boolean validColumn(List<Integer> road, int row, int column, int n) {
            if (road.contains(column)) {
                return false;
            }
            for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
                if (road.contains(j) && road.indexOf(j) == i) {
                    return false;
                }
            }

            for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
                if (road.contains(j) && road.indexOf(j) == i) {
                    return false;
                }
            }
            return true;
        }


        /**
         * N 皇后回溯框架
         *
         * @param road road
         * @param n    n
         * @param row  row
         */
        public void backtrack(List<Integer> road, int n, int row) {
            if (row == n) { // 1. 如果满足条件
                addToResult(road, n);  //2 .添加路径
                return; // 3. 返回
            }
            for (int column = 0; column < n; ++column) {  // 4. for 选择 in 选择列表
                boolean flag = validColumn(road, row, column, n);  //5. 做选择
                if (!flag) {
                    continue;
                }
                road.add(column);  //5. 做选择
                backtrack(road, n, row + 1); //6. 回溯
                road.remove((Integer) column); //7. 撤销选择
            }
        }

        /**
         * 全排列，回溯解法
         */
//        List<List<Integer>> result = new ArrayList<>();
////
//        public List<List<Integer>> permute(int[] nums) {
//            List<Integer> arrange = new ArrayList<>();
//            backtrack(nums, arrange);
//            System.out.println(result);
//            return result;
//        }
//
//        public void backtrack(int[] nums, List<Integer> arrange) {
//            if (arrange.size() == nums.length) {
//                result.add(new ArrayList<>(arrange));
//                return;
//            }
//
//            for (int num : nums) {
//                if (arrange.contains(num)) {
//                    continue;
//                }
//                arrange.add(num);
//                backtrack(nums, arrange);
//                arrange.remove(arrange.indexOf(num));
//            }
//        }

        /**
         * 滑动窗口
         *
         * @param s
         * @param t
         * @return
         */
        public String minWindow(String s, String t) {
            //窗口大小使用right - left来表示
            //window保存的是窗口内涵盖t的字符数
            //valid表示window和need匹配的字符数
            //最小的窗口使用start和subStrLen来保存
            int[] needs = new int[128];
            for (int i = 0; i < t.length(); ++i) {
                ++needs[t.charAt(i)];
            }
            int totalVaryChar = 0;
            for (int i : needs) {
                if (i != 0) {
                    totalVaryChar++;
                }
            }
            int[] window = new int[128];
            int left = 0, right = 0, valid = 0;
            int start = 0, subStrLen = 100001;
            while (right < s.length()) {
                char validChar = s.charAt(right);
                right++;

                if (needs[validChar] != 0) {
                    window[validChar]++;
                    if (window[validChar] == needs[validChar]) {
                        valid++;
                    }
                }

                while (valid == totalVaryChar) {
                    if (right - left < subStrLen) {
                        start = left;
                        subStrLen = right - left;
                    }

                    char removeChar = s.charAt(left);
                    left++;

                    if (needs[removeChar] != 0) {
                        if (window[removeChar] == needs[removeChar]) {
                            valid--;
                        }
                        window[removeChar]--;
                    }
                }
            }
            return subStrLen == 100001 ? "" : s.substring(start, start + subStrLen);
        }

        public boolean checkInclusion(String s1, String s2) {
            int[] needs = new int[128];
            int[] window = new int[128];
            int left = 0, right = 0, valid = 0;
            int start = 0, len = 10001;
            int diff = 0;
            for (int i = 0; i < s1.length(); ++i) {
                if (needs[s1.charAt(i)] == 0) {
                    diff++;
                }
                needs[s1.charAt(i)]++;
            }

            while (right < s2.length()) {
                char inWindow = s2.charAt(right);
                right++;

                //右移窗口之后更新参数
                if (needs[inWindow] != 0) {
                    window[inWindow]++;
                    if (window[inWindow] == needs[inWindow]) {
                        ++valid;
                    }
                }
                //判断窗口什么时候收缩
                while (right - left >= s1.length()) {
                    //判断是否找到了合法的字串
                    if (valid == diff) {
                        return true;
                    }
                    char outWindow = s2.charAt(left);
                    ++left;
                    if (needs[outWindow] != 0) {
                        if (window[outWindow] == needs[outWindow]) {
                            --valid;
                        }
                        window[outWindow]--;
                    }
                }
            }
            return false;
        }

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            int[] need = new int[128];
            int[] window = new int[128];
            int left = 0, right = 0, vaild = 0, diff = 0;
            for (int i = 0; i < p.length(); ++i) {
                if (need[p.charAt(i)] == 0) {
                    diff++;
                }
                need[p.charAt(i)]++;
            }
            while (right < s.length()) {
                char in = s.charAt(right);
                right++;
                if (need[in] != 0) {
                    window[in]++;
                    if (window[in] == need[in]) {
                        vaild++;
                    }
                }

                while (right - left >= p.length()) {
                    if (vaild == diff && right - left == p.length()) {
                        result.add(left);
                    }

                    char out = s.charAt(left);
                    left++;

                    if (need[out] != 0) {
                        if (window[out] == need[out]) {
                            vaild--;
                        }
                        window[out]--;
                    }
                }
            }
            return result;
        }

        public int lengthOfLongestSubstring1(String s) {
            int left = 0, right = 0;
            int[] window = new int[128];
            int res = 0;
            while (right < s.length()) {
                char in = s.charAt(right++);
                window[in]++;
                System.out.println("window: [" + left + ", " + right + "], " + s.substring(left, right));
                while (window[in] > 1) {
                    char out = s.charAt(left++);
                    window[out]--;
                }
                res = Math.max(res, right - left);
            }
            return res;
        }

//        /**
//         * 44. 通配符匹配 动态规划
//         *
//         * @param s string
//         * @param p pattern
//         * @return isMath
//         */
//        public boolean isMatch(String s, String p) {
//            int m = s.length();
//            int n = p.length();
//            boolean[][] dp = new boolean[m + 1][n + 1];
//            dp[0][0] = true;
//            for (int i = 1; i <= n; ++i) {
//                if (p.charAt(i - 1) == '*') {
//                    dp[0][i] = true;
//                } else {
//                    break;
//                }
//            }
//            for (int i = 1; i <= m; ++i) {
//                for (int j = 1; j <= n; ++j) {
//                    if (p.charAt(j - 1) == '*') {
//                        // 前一种表示*不匹配任何字符，后一种表示*在当前位置匹配一个字符
//                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
//                    } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
//                        dp[i][j] = dp[i - 1][j - 1];
//                    }
//                }
//            }
//            return dp[m][n];
//        }

        public boolean isMatch(String s, String p) {
            if (s.isEmpty() || p.isEmpty()) {
                return false;
            }
            return matchCore(s, p, 0, 0);
        }

        public boolean matchCore(String s, String p, int i, int j) {
            if (i == s.length() - 1 && j == p.length() - 1) {
                return true;
            }
            if (i != s.length() - 1 && j == p.length() - 1) {
                return false;
            }

            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                if (s.charAt(i) == p.charAt(j) || (p.charAt(j) == '.' && i != s.length() - 1)) {
                    return matchCore(s, p, i + 1, j + 2) || matchCore(s, p, i + 1, j) || matchCore(s, p, i, j + 2);
                } else {
                    return matchCore(s, p, i, j + 2);
                }
            }
            if (j < p.length() && s.charAt(i) == p.charAt(j) || (p.charAt(j) == '.' && i != s.length() - 1)) {
                return matchCore(s, p, i + 1, j + 1);
            }
            return false;
        }

        public int reversePairs(int[] nums) {
            int[] temp = new int[nums.length];
            return mergeSort(nums, 0, nums.length - 1, temp);
        }

        public int mergeSort(int[] nums, int left, int right, int[] temp) {
            if (left < right) {
                int mid = left + (right - left) / 2;
                int left_num = mergeSort(nums, left, mid, temp);
                int right_num = mergeSort(nums, mid + 1, right, temp);
                return merge(nums, left, mid, right, temp) + left_num + right_num;
            }
            return 0;
        }

        public int merge(int[] nums, int left, int mid, int right, int[] temp) {
            for (int i = left; i <= right; ++i) {
                temp[i] = nums[i];
            }
            int i = left, j = mid + 1, k = left;
            int res = 0;
            while (i <= mid && j <= right) {
                if (temp[i] < temp[j]) {
                    nums[k] = temp[i];
                    ++k;
                    ++i;
                    res += k - i;
                } else {
                    nums[k] = temp[j];
                    ++k;
                    ++j;
                }
            }
            while (i <= mid) {
                nums[k] = temp[i];
                ++k;
                ++i;
                res += k - i;
            }
            while (j <= right) {
                nums[k] = temp[j];
                ++k;
                ++j;
            }
            return res;
        }

        private Map<TreeNode, Integer> mem = new HashMap<>();

        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (mem.containsKey(root)) {
                return mem.get(root);
            }

            int do_it = root.val
                    + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                    + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
            int not_do_it = rob(root.left) + rob(root.right);
            int res = Math.max(do_it, not_do_it);
            mem.put(root, res);
            return res;
        }

        public String Probability(int n) {
            // write code here
            double res = 1.0;
            for (int i = 0; i < n; ++i) {
                res *= 2;
            }
            res = 2 / res;
            String b = "" + res;
            int len = b.length();
            if (len < 4) {
                for (int i = len; i <= 4; ++i) {
                    b += "0";
                }
            }
            int t = b.charAt(4) - '0';
            if (t >= 5) {
                String p = b.charAt(3) + 1 - '0' + "";
                String p1 = b.substring(0, 3);
                return p1 + p;
            }

            return b.substring(0, 4);
        }

//        void QuickSort(int[] A, int low, int high) {
//            if (low < high) {
//                int piv = Partition(A, low, high);
//                QuickSort(A, low, piv - 1);
//                QuickSort(A, piv + 1, high);
//            }
//        }
//
//        int Partition(int[] A, int low, int high) {
//            int temp = A[low];
//            while (low < high) {
//                while (low < high && A[high] >= temp) {
//                    --high;
//                }
//                A[low] = A[high];
//                while (low < high && A[low] <= temp) {
//                    ++low;
//                }
//                A[high] = A[low];
//            }
//            A[low] = temp;
//            return low;
//        }

        public int Answerofjudge(int[] arr) {
            // write code here
            int len = arr.length;
            double avg = Arrays.stream(arr).sum() / (double) len;
            Arrays.sort(arr);
            double mi = arr[len / 2];
            if (len % 2 == 0) {
                mi += arr[(len / 2) - 1];
                mi /= 2.0;
            }
            if (mi == avg) {
                return 0;
            }
            return mi > avg ? 1 : -1;
        }

        public int Maximumlength(String x) {
            // write code here
            int len = x.length();
            int[] count = new int[26];
            int left = 0, right = 0;
            int window = 0;
            int res = 0;
            while (right < len) {
                char cur = x.charAt(right);
                count[cur - 'a']++;
                right++;
                window++;
                System.out.println("window: " + left + " " + right);

                while (count['n' - 'a'] > 0 && count['p' - 'a'] > 0 && count['y' - 'a'] > 0 && window > 0) {
                    char out = x.charAt(left);
                    window--;
                    left++;
                    count[out - 'a']--;
                }
                res = Math.max(res, window);
            }
            return res;
        }

        public long solve(String str) {
            // write code here
            long res = 0;
            Stack<Long> s = new Stack<>();
            int i = 0;
            while (i < str.length()) {
                char cur = str.charAt(i);
                StringBuilder sb = new StringBuilder();
                boolean flag = false;
                while (cur != '+' && cur != '-' && cur != '*' && cur != '#') {
                    sb.append(cur);
                    i++;
                    cur = str.charAt(i);
                    flag = true;
                }
                if (flag) {
                    s.push(Long.parseLong(sb.toString()));
                    continue;
                }

                if (cur == '+') {
                    long a2 = s.pop();
                    long a1 = s.pop();
                    res = a1 + a2;
                    s.push(res);
                }

                if (cur == '-') {
                    long a2 = s.pop();
                    long a1 = s.pop();
                    res = a1 - a2;
                    s.push(res);
                }

                if (cur == '*') {
                    long a2 = s.pop();
                    long a1 = s.pop();
                    res = a1 * a2;
                    s.push(res);
                }
                i++;
            }
            return res;
        }

        int solve(int a, int b, int n) {
            // write code here
            if (n < a) {
                return 0;
            }
            int p = n / a;
            if (p == 1) {
                if (b == 0) {
                    return n;
                } else {
                    return 0;
                }
            } else {
                if (p * a + b <= n) {
                    return p * a + b;
                }
                return (p - 1) * a + b;
            }
        }

        public int string2(int k, String s) {
            // write code here
            int len = s.length();
            char[] ch = s.toCharArray();
            Set<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            q.offer(new String(ch));
            visited.add(new String(ch));
            int res = 0;

            int depth = 0;
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; ++i) {
                    String cur = q.poll();
                    res = Math.max(res, maxSame(cur));
                    if (depth > k) {
                        return res;
                    }

                    for (int j = 0; j < len; ++j) {
                        String up = upCharJ(cur, j);
                        if (!visited.contains(up)) {
                            q.offer(up);
                            visited.add(up);
                        }

                        String down = downCharJ(cur, j);
                        if (!visited.contains(down)) {
                            q.offer(down);
                            visited.add(down);
                        }
                    }
                }
                depth++;
            }
            return -1;
        }

        public String upCharJ(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] != 'z') {
                ch[j] += 1;
            }
            return new String(ch);
        }

        public String downCharJ(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] != 'a') {
                ch[j] -= 1;
            }
            return new String(ch);
        }


        public int maxSame(String s) {
            char[] temp = new char[26];
            for (int i = 0; i < s.length(); ++i) {
                temp[s.charAt(i) - 'a']++;
            }
            int res = 0;
            for (int i = 0; i < temp.length; ++i) {
                res = Math.max(res, temp[i]);
            }
            return res;
        }

        public int maxOperations(int[] nums, int k) {
            Arrays.sort(nums);//先排序
            int ans = 0, p = nums.length - 1;
            //使用快排思想进行遍历计数
            for (int i = 0; i < p; i++) {
                while (i < p && nums[i] + nums[p] > k)//快速缩小数组遍历规模
                {
                    p--;
                }
                if (i >= p) {
                    break;
                }
                if (nums[i] + nums[p] == k) {
                    ans++;
                    p--;
                }
            }
            return ans;
        }

        public int Maximumlength1(String x) {
            // write code here
            int len = x.length();
            int res = 0;
            int[] f = new int[3];
            int i = 0;
            while (i < len) {
                boolean flag = false;
                while (i < len && x.charAt(i) == 'a') {
                    f[0]++;
                    i++;
                    flag = true;
                }
                if (i < len && x.charAt(i) != 'b' && flag) {
                    f[0] = 0;
                    f[1] = 0;
                    f[2] = 0;
                    continue;
                }
                while (i < len && x.charAt(i) == 'b') {
                    f[1]++;
                    i++;
                    flag = true;
                }
                if (i < len && x.charAt(i) != 'c' && flag) {
                    f[0] = 0;
                    f[1] = 0;
                    f[2] = 0;
                    continue;
                }
                while (i < len && x.charAt(i) == 'c') {
                    f[2]++;
                    i++;
                    flag = true;
                }

                if (f[0] >= f[1] && f[2] >= f[1]) {
                    res = Math.max(res, f[1] * 3);
                }
                f[0] = 0;
                f[1] = 0;
                f[2] = 0;
                if (!flag) {
                    ++i;
                }

            }
            return res;
        }

        public int stoneGameVII(int[] stones) {
            int len = stones.length;
            int[][][] dp = new int[len][len][2];
            for (int i = 1; i < len; ++i) {
                dp[i - 1][i][0] = Math.max(stones[i], stones[i - 1]);
            }
            int[][] mem = new int[len][len];
            for (int i = 0; i < len; ++i) {
                int sum = stones[i];
                mem[i][i] = sum;
                for (int j = i + 1; j < len; ++j) {
                    sum += stones[j];
                    mem[i][j] = sum;
                }
            }
            // dp[i][j][0] = max(mem[i+1][j]+dp[i+1][j][1], mem[i][j-1]+dp[i][j-1][1]);
            for (int l = 3; l <= len; ++l) {
                for (int i = 0; i <= len - l; ++i) {
                    int j = l + i - 1;
                    int left = mem[i + 1][j] + dp[i + 1][j][1];
                    int left1 = dp[i + 1][j][0];
                    int right = mem[i][j - 1] + dp[i][j - 1][1];
                    int right1 = dp[i][j - 1][0];
                    if (Math.abs(left1 - left) > Math.abs(right - right1)) {
                        dp[i][j][0] = left;
                        dp[i][j][1] = left1;
                    } else {
                        dp[i][j][0] = right;
                        dp[i][j][1] = right1;
                    }
                }
            }
            Arrays.sort(dp, new Comparator<int[][]>() {
                @Override
                public int compare(int[][] o1, int[][] o2) {
                    return 0;
                }
            });
            return dp[0][len - 1][0] - dp[0][len - 1][1];
        }

        public int maxHeight(int[][] cuboids) {
            int len = cuboids.length;
            int[][] c = new int[len * 6][3];
            for (int i = 0; i < len; ++i) {
                c[i * 6 + 0][0] = cuboids[i][0];
                c[i * 6 + 0][1] = cuboids[i][1];
                c[i * 6 + 0][2] = cuboids[i][2];
                c[i * 6 + 1][0] = cuboids[i][0];
                c[i * 6 + 1][1] = cuboids[i][2];
                c[i * 6 + 1][2] = cuboids[i][1];
                c[i * 6 + 2][0] = cuboids[i][1];
                c[i * 6 + 2][1] = cuboids[i][0];
                c[i * 6 + 2][2] = cuboids[i][2];
                c[i * 6 + 3][0] = cuboids[i][1];
                c[i * 6 + 3][1] = cuboids[i][2];
                c[i * 6 + 3][2] = cuboids[i][0];
                c[i * 6 + 4][0] = cuboids[i][2];
                c[i * 6 + 4][1] = cuboids[i][1];
                c[i * 6 + 4][2] = cuboids[i][0];
                c[i * 6 + 5][0] = cuboids[i][2];
                c[i * 6 + 5][1] = cuboids[i][0];
                c[i * 6 + 5][2] = cuboids[i][1];
            }
            Arrays.sort(c, (a, b) -> {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return b[0] - a[0];
                }
            });
            int[] dp = new int[len * 6];
            int res = 0;
            for (int i = 0; i < len * 6; ++i) {
                dp[i] = c[i][2];
                res = Math.max(res, dp[i]);
                for (int j = 0; j < i; ++j) {
                    if (c[i][0] <= c[j][0] && c[i][1] <= c[j][1] && Math.abs(j - i) > 5) {
                        dp[i] = Math.max(dp[i], dp[j] + c[i][2]);
                        res = Math.max(res, dp[i]);
                    }
                }
            }
            return res;
        }

        public int majorityElement(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }

            int index = Partition(nums, 0, len - 1);
            int middle = (nums.length >> 1);
            while (index != middle) {
                if (index > middle) {
                    //res in left
                    index = Partition(nums, 0, index - 1);
                } else {
                    // res in right
                    index = Partition(nums, index + 1, len - 1);
                }
            }
            return nums[index];
        }

        public int Partition(int[] nums, int left, int right) {
            int temp = nums[left];
            while (left < right) {
                while (left < right && nums[right] >= temp) {
                    --right;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] <= temp) {
                    ++left;
                }
                nums[right] = nums[left];
                ;
            }
            nums[left] = temp;
            return left;
        }

        public int strToInt(String str) {
            char[] s = str.toCharArray();
            int len = s.length;
            if (len == 0) {
                return 0;
            }
            int i = 0;
            while (i < len && s[i] == ' ') {
                i++;
            }
            if (i == len) {
                return 0;
            }
            int flag = 1;
            if (s[i] == '+') {
                ++i;
            } else if (s[i] == '-') {
                flag = -1;
                ++i;
            }
            int res = 0;
            for (; i < len; ++i) {
                if (!(s[i] >= '0' && s[i] <= '9')) {
                    break;
                }
                if (res > Integer.MAX_VALUE / 10) {
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else if (res == Integer.MAX_VALUE / 10) {
                    if (flag == 1) {
                        if (s[i] - '0' > 7) {
                            return Integer.MAX_VALUE;
                        }
                    } else {
                        if (s[i] - '0' > 8) {
                            return Integer.MIN_VALUE;
                        }
                    }
                }

                res = res * 10 + (s[i] - '0');
            }
            return res * flag;
        }

    }
        public int[][] findContinuousSequence(int target) {
            List<int[]> res = new ArrayList<>();
            int left = 1, right = 1;
            int sum = 0;
            while (right < (target + 1) / 2) {
                int in_cur = right;
                sum += right;
                right++;
                while (sum > target) {
                    int out_cur = left;
                    sum -= out_cur;
                    left++;
                }
                if (sum == target) {
                    int[] temp = new int[right - left + 1];
                    int index = 0;
                    for (int i = left; i < right; ++i) {
                        temp[index] = i;
                        ++index;
                    }
                    res.add(temp);
                }
            }
            return res.toArray(new int[res.size()][]);
        }

        public double[] dicesProbability(int n) {
            int[][] dp = new int[n][6 * n];
            for (int i = 0; i < 6; ++i) {
                dp[0][i] = 1;
            }

            for (int i = 1; i < n; ++i) {
                for (int j = i; j < 6 * i; ++j) {
                    for (int k = 0; k < 6; ++k) {
                        if (j - k > 0) {
                            dp[i][j] += dp[i - 1][j - k];
                        } else {
                            break;
                        }
                    }
                }
            }

            double[] res = new double[6 * n];
            double max = Math.pow(6, n);
            int index = 0;
            for (int i = n - 1; i < 6 * n; ++i) {
                res[index] = dp[n - 1][i] / max;
                index++;
            }
            return res;
        }

        int i;

        int func() {
            return i++;
        }

        int func1() {
            return func() + func() + func() + func();
        }

        int func2() {
            return 4 * func();
        }

        public int tupleSameProduct(int[] nums) {
            int len = nums.length;
            int[][] m = new int[len][len];
            Arrays.sort(nums);

            int res = 0;
            for (int l = 0; l < len - 1; ++l) {
                for (int r = len - 1; r > l; --r) {
                    int target = nums[l] * nums[r];
                    int t_l = l + 1, t_r = r - 1;
                    while (t_l < t_r) {
                        if (m[t_l][t_r] == 0) {
                            int c = nums[t_l] * nums[t_r];
                            m[t_l][t_r] = c;
                        }
                        if (m[t_l][t_r] == target) {
                            t_r--;
                            t_l++;
                            res++;
                        } else if (m[t_l][t_r] > target) {
                            t_r--;
                        } else {
                            t_l++;
                        }
                    }
                }
            }
            return res * 8;
        }

        private AtomicReference<Thread> cas = new AtomicReference<>();
        private AtomicInteger ticketNum = new AtomicInteger();

        public void lock() {
            Thread c = Thread.currentThread();
            while (!cas.compareAndSet(null, c)) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public <E> void printArray(E[] inputArray) {
            for (E element : inputArray) {
                System.out.printf("%s ", element);
            }
            System.out.println();
        }


    }

    class Node {
        int key, val;
        Node next, pre;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        Node first, last;
        int size;

        public DoubleList() {
            first = new Node(0, 0);
            last = new Node(0, 0);
            first.next = last;
            last.next = first;
        }
    }


    public static void main(String[] args) {
//        int[] a = new int[]{6, 6, 6, 6, 5, 8};
//        //小顶堆
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);
        //大顶堆
        PriorityQueue<Integer> q1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        //队列
        String a = "";
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
//        //队列
//        Queue<Integer> arrayDeque = new ArrayDeque<>();
//        Queue<Integer> linkedListQueue = new LinkedList<>();
//
//        //双端队列
        Deque<Integer> arrayDeque1 = new ArrayDeque<>();
//        Deque<Integer> deque = new LinkedList<>();
//        LinkedList<Integer> linkedList = new LinkedList<>();
//
//        List<Integer> list = new ArrayList<>();
//        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
//
        Map<Integer, Character> m = new TreeMap<>(Comparator.reverseOrder());
        List<int[]> list = new ArrayList<>();
        list.toArray(new int[list.size()][]);

//        Map<Integer, Integer> map = new HashMap<>();
//        Map<Integer, Integer> hashTable = new Hashtable<>();
//
//        //集合
//        Set<Integer> set = new HashSet<>();
//        Set<Integer> treeSet = new TreeSet<>();
//        // 栈，继承自Vector，线程安全
//        Stack<Integer> stack = new Stack<>();
//        String string = new String("");
//        StringBuilder stringBuilder = new StringBuilder();

//        Vector<Integer> v = new Vector<>();
//        byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
//        allocation1 = new byte[Integer.MAX_VALUE];
//        allocation2 = new byte[2000*1024];
//        allocation3 = new byte[1000*1024];
//        allocation4 = new byte[1000*1024];
//        allocation5 = new byte[1000*1024];

        Solution solution = new Solution();
        System.out.println(solution.tupleSameProduct(new int[]{2, 3, 4, 6}));

//        List<Integer> list1 = new ArrayList<>();
//
//        list1.add(1);
//        list1.add(2);
////这里直接添加会报错
////        list1.add("a");
//        Class<? extends List> clazz = list1.getClass();
//        Method add = null;
//        try {
//            add = clazz.getDeclaredMethod("add", Object.class);
//            add.invoke(list1, "kl");
//            System.out.println(list1.get(0));
//        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);
        solution.printArray(new Integer[]{1, 23, 4});

        System.out.println(list1.getClass() == list2.getClass());

        Vector<Integer> v = new Vector<>();
        System.out.println(Integer.MIN_VALUE % 10);
        System.out.println(Integer.MAX_VALUE % 10);
        Solution solution = new Solution();
        String s1 = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        System.out.println(s2);//计算机
        System.out.println(s1 == s2);//false，因为一个是堆内存中的 String 对象一个是常量池中的 String 对象，
        System.out.println(s3 == s2);//true，因为两个都是常量池中的 String 对象
//
//        Integer a = 100;
//        Integer b = new Integer(100);
//
//        System.out.println(a == b);
    }
}
