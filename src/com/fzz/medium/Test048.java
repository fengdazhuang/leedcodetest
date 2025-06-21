package com.fzz.medium;

import java.util.Arrays;

public class Test048 {
    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution48.rotate(matrix);

    }
}

/**
 * 思路：
 * 会发现每四个元素的值为互相转化的关系
 * 可以整体只遍历1/4个矩阵，每次交换相关四个元素的位置
 */
class Solution48 {
    public void rotate(int[][] matrix) {
        int n= matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
