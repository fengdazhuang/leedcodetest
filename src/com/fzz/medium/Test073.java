package com.fzz.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test073 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        new Solution73().setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

/**
 * 1：第一次双层for循环遍历矩阵，使用两个set分别存储有0的行和列，然后第二次遍历将这些行和列上的元素设为0
 *    空间O（m+n）
 * 2：使用第一行和第一列保存记录该行该列是否有0
 *    空间O（1）
 */
class Solution73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }

            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(row.contains(i)||col.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
}