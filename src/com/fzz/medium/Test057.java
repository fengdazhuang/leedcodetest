package com.fzz.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test057 {
    public static void main(String[] args) {
        int[][] insert = new Solution57().insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
//        int[][] insert = new Solution57().insert(new int[][]{{1, 5}}, new int[]{2, 7});
        System.out.println(Arrays.deepToString(insert));

    }
}

/**
 * 思路：
 * 主要是注意边界判断，不同情况要考虑全面
 */
class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if(len==0) return new int[][]{newInterval};
        //这里用了List暂存结果，为了避免复制数组，可以最后将List直接转为数组返回
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0],end = newInterval[1];
        int i ;
        for (i = 0; i < len; i++) {
            if(start>intervals[i][1]){
                res.add(new int[]{intervals[i][0], intervals[i][1]});
                continue;
            }
            if(end<intervals[i][0]){
                res.add(new int[]{start,end});
                res.addAll(Arrays.asList(intervals).subList(i,len));
                break;
            }
            //插入区间包含在了原区间数组中，直接返回原数组
            if(start>=intervals[i][0]&&end<=intervals[i][1]){
                return intervals;
            }
            //插入区间包含了该区间
            if(start<=intervals[i][0]&&end>intervals[i][1]){
                continue;
            }
            //区间有交叉，根据边界条件，更新插入区间的start和end
            if(start>=intervals[i][0]&&start<=intervals[i][1]){
                start = intervals[i][0];
            }
            if(end>=intervals[i][0]&&end<=intervals[i][1]){
                end = intervals[i][1];
            }

        }
        if(i==len){
            res.add(new int[]{start,end});
        }
        return res.toArray(int[][]::new);

    }
}