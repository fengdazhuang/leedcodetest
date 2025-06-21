package com.fzz.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test056 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = new Solution56().merge(intervals);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}


/**
 * 思路：
 * 先排序，然后遍历，通过判断前一个区间和当前区间是三种关系中的哪一种，选择是否将前一个区间插入，或更新前一个区间的范围
 */
class Solution56 {
    public int[][] merge(int[][] intervals) {
        //先将所有区间按start排序
        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]));
        int len = intervals.length;
        if (len <= 1) return intervals;
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            //前后区间不相连
            if (end < intervals[i][0]) {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            //前区间包后区间
            if (end >= intervals[i][1]) {
                continue;
            }
            //区间相交
            if (end >= intervals[i][0] && end < intervals[i][1]) {
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);
    }
}