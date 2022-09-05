package org.snailgary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/minimum-path-sum/
 * Created by wangzhongfu on 2022/9/5
 * 64. 最小路径和
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid.length == 1) {
            return Arrays.stream(grid[0]).sum();
        }
        int rowCnt = grid.length;
        int columnCnt = grid[0].length;
        // int minPathSum = grid[0][0];

        int[][] dp = new int[rowCnt][columnCnt];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rowCnt; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columnCnt; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rowCnt; i++) {
            for (int j = 1; j < columnCnt; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        /*for (int[] ints : dp) {
            List<Integer> integerList = new ArrayList<>();
            for (int anInt : ints) {
                integerList.add(anInt);
            }
            System.out.println(integerList);
        }*/

        return dp[rowCnt - 1][columnCnt - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new MinimumPathSum().minPathSum(grid));
    }


}
