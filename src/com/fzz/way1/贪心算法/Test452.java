package com.fzz.way1.贪心算法;
/*
输入：points = [[10,16],[2,8],[1,6],[7,12]]
输出：2
解释：气球可以用2支箭来爆破:
-在x = 6处射出箭，击破气球[2,8]和[1,6]。
-在x = 11处发射箭，击破气球[10,16]和[7,12]。
 */


import java.util.Arrays;
import java.util.Comparator;


public class Test452 {

    //[1,2]     [2,3]     [3,4]    [4,5]
    public static void main(String[] args) {
        int[][] points={{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        int minArrowShots = new Solution452().findMinArrowShots(points);
        System.out.println(minArrowShots);

    }


}


class Solution452 {
    public int findMinArrowShots(int[][] points) {
        /*if(points.length==1){
            return 1;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]<o2[1]){
                    return -1;
                }else if(o1[1]>o2[1]){
                    return 1;
                }else{
                    if(o1[0]>o2[0]){
                        return 1;
                    }else if(o1[0]<o2[0]){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }
        });

        //[1,6]     [2,8]     [7,12]    [10,16]
        int sum=0;
        int rb=points[0][1];
        int lb=points[0][0];
        int countTemp=0;
        for(int i=1;i< points.length;i++){
            if(rb==points[i][1]){
                lb=Math.max(lb,points[i][0]);
            } else if(rb> points[i][0]){
                lb=Math.max(lb,points[i][0]);
                if(i==points.length-1){
                    sum++;
                }
                countTemp++;
            }else if(rb==points[i][0]){
                sum=countTemp>0?sum+2:sum+1;
                countTemp=0;
                if(i+1< points.length){
                    i++;
                    rb=points[i][1];
                    lb=points[i][0];
                }

            }else if(i==points.length-1){
                sum=sum+2;
            }

            else {
                if(i==points.length-1){
                    sum++;
                }
                sum++;
                rb=points[i][1];
                lb=points[i][0];
            }
        }

        return sum;*/

        //排序 + 贪心
        if(points.length==1){
            return 1;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;

    }
}
