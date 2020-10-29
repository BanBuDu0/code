package com.syj;

import javax.swing.*;
import java.util.*;

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
         * 44. 通配符匹配 动态规划
         *
         * @param s string
         * @param p pattern
         * @return isMath
         */
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; ++i) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = true;
                } else {
                    break;
                }
            }
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        // 前一种表示*不匹配任何字符，后一种表示*在当前位置匹配一个字符
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            return dp[m][n];
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
                    if ((i < strs[j].length() && strs[j].charAt(i) != t) || i >= strs[j].length()) {
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
                    if (sentence.substring(i - dictionary[j].length(), i).equals(dictionary[j])) {
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
                road.add(column);
                backtrack(road, n, row + 1); //6. 回溯
                road.remove(road.indexOf(column)); //7. 撤销选择
            }
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(4);

    }
}
