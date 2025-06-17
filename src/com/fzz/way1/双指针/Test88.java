package com.fzz.way1.双指针;

/*
88. 合并两个有序数组

给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n
 */


/*
示例 1：
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 */

import java.util.Arrays;

public class Test88 {
    public static void main(String[] args) {
        int[] num1={1,2,3,0,0,0};
        int[] num2={2,5,6};
        new Solution88().merge(num1,3,num2,3);
        Arrays.stream(num1).forEach(System.out::println);
    }
}

class Solution88 {
    //双指针
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos1=0,pos2=0;
        int[] mergedNum=new int[m+n];
        int i=0;
        while(pos1<m&&pos2<n){
            if(nums1[pos1]<=nums2[pos2]){
                mergedNum[i]=nums1[pos1];
                i++;
                pos1++;
            }else{
                mergedNum[i]=nums2[pos2];
                i++;
                pos2++;
            }
        }
        while(pos2<n){
            mergedNum[i]=nums2[pos2];
            i++;
            pos2++;
        }
        while(pos1<n){
            mergedNum[i]=nums2[pos1];
            i++;
            pos1++;
        }
        for(int j=0;j<mergedNum.length;j++){
            nums1[j]=mergedNum[j];
        }
    }
}
