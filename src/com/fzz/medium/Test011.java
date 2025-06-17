package com.fzz.medium;

import java.util.AbstractList;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Test011 {
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        Solution11 solution=new Solution11();
        System.out.println(solution.maxArea(height));

    }
}

/**
 * 面积：底*高
 * 定义左右两个指针，每次根据左和右指针所在线长度，选择移动哪个指针
 * 每次移动指针，底变小，所以高要尽可能大，所以要移动较低线所在位置的指针
 * 比较当前水容量和之前最大水容量来更新最大值
 * 循环结束直接返回res即可
 */
class Solution11 {
    public int maxArea(int[] height) {
         int n=height.length;
         int res=0;
         int left=0;
         int right=n-1;
         while(left<right){
             res=Math.max(res,Math.min(height[left],height[right])*(right-left));
             if(height[left]<height[right]){
                 left++;
             }else
                 right--;
         }
         return res;
    }
}