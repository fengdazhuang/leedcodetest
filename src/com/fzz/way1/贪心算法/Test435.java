package com.fzz.way1.贪心算法;

import java.util.Arrays;
import java.util.Comparator;


public class Test435 {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{1,2},{1,2}};
        int i = new Solution435().eraseOverlapIntervals(intervals);
        System.out.println(i);
    }
}

/**
 * 在选择要保留区间时，区间的结尾十分重要：选择的区间结尾越小，余留给其它区间的空间
 * 就越大，就越能保留更多的区间。因此，我们采取的贪心策略为，优先保留结尾小且不相交的区
 * 间。
 * 具体实现方法为，先把区间按照结尾的大小进行增序排序，每次选择结尾最小且和前一个选
 * 择的区间不重叠的区间。
 */

class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int num=0;

        Arrays.sort(intervals, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1]-o2[1];
                    }
                }
        );
        int back=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(back>intervals[i][0]){
                num++;
            }else{
                back=intervals[i][1];

            }
        }
        return num;
    }
}
