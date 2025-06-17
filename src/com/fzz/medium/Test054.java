package com.fzz.medium;

import java.util.ArrayList;
import java.util.List;

public class Test054 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
                {17,18,19,20},
                {21,22,23,24}};
        List<Integer> list = new Solution54().spiralOrder(matrix);
        System.out.println(list);
    }

}

/**
 * 不停遍历矩阵就可以了
 * 关键是处理好边界关系
 */
class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int rowDown=0,rowUp=row-1,colDown=0,colUp=col-1;
        while(rowDown<rowUp&&colDown<colUp){
            for(int i=colDown;i<=colUp;i++){
                list.add(matrix[rowDown][i]);
            }
            for(int i=rowDown+1;i<=rowUp-1;i++){
                list.add(matrix[i][colUp]);
            }
            for(int i=colUp;i>=colDown;i--){
                list.add(matrix[rowUp][i]);
            }
            for(int i=rowUp-1;i>=rowDown+1;i--){
                list.add(matrix[i][colDown]);
            }
            rowDown++;
            rowUp--;
            colDown++;
            colUp--;
        }
        if(rowDown>rowUp||colDown>colUp) return list;

        if(rowDown==rowUp&&colDown==colUp){
            for(int i=colDown;i<=colUp;i++){
                list.add(matrix[colDown][i]);
            }
        } else if (rowDown==rowUp) {
            for(int i=colDown;i<=colUp;i++){
                list.add(matrix[colDown][i]);
            }
        }else {
            for(int i=rowDown;i<=rowUp;i++){
                list.add(matrix[i][colUp]);
            }
        }
        return list;
    }


}