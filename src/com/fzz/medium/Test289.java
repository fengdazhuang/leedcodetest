package com.fzz.medium;

import java.util.Arrays;

public class Test289 {

    public static void main(String[] args) {
        Solution289 solution289 = new Solution289();
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        solution289.gameOfLife(board);
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }
}


/**
 * 思路：
 * 先复制原数组作为观测数组
 * 遍历数组，计算每个元素周围8个邻居中存活的数量，然后根据自身状态更新下一刻的状态
 *
 */
class Solution289 {
    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(board[i], 0, temp[i], 0, n);
        }
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int live = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                            if ((r < m && r >= 0) && (c < n && c >= 0) && (temp[r][c] == 1)) {
                                live += 1;
                            }
                        }
                    }
                }
                if ((temp[row][col] == 1) && (live < 2 || live > 3)) {
                    board[row][col] = 0;
                }
                if (temp[row][col] == 0 && live == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }
}