package com.fzz.medium;

import com.fzz.utils.RadixSort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test128 {
    public static void main(String[] args) {
        int[] nums = {0,-1};

        Solution128 solution128 = new Solution128();
//        Solution128.radixSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(solution128.longestConsecutive(nums));
    }
}


/**
 * 使用基数排序算法将nums数组先排序，同时去重，因为有负数所以先将每个元素加上2的30次方
 * 基数排序时间复杂度O(d*(n+k)) 近似O(n)     d:最大元素的位数    k:基数，每位可能的取值个数
 * 本方法的d因为负数消负操作导致非常大，为10
 * 之后就循环数组，比较并选择更新最长连续数字个数
 */
class Solution128 {

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len <=1) return len;
        int maxLen=0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num + 1;
                int curLen = 1;
                while (set.contains(curNum)) {
                    curLen++;
                    curNum++;
                }
                maxLen = Math.max(maxLen, curLen);
            }

        }
        return maxLen;

    }


    public int longestConsecutive1(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int number= (int) Math.pow(2,30);
        int[] array = Arrays.stream(nums).distinct().map(num -> num + number).toArray();
        RadixSort.radixSort(array);
        System.out.println(Arrays.toString(array));
        int maxLen=1;
        int curLen=1;
        int temp=array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]==temp+1){
                curLen++;
            }else{
                maxLen=Math.max(maxLen,curLen);
                curLen=1;
            }
            temp=array[i];
        }
        return Math.max(maxLen, curLen);
    }



}